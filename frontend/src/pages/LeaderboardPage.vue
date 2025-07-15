// Quasar Leaderboard UI - Full Assignment Requirements (Vue 3 + Composition API + JavaScript)

<template>
  <q-page class="q-pa-md">
    <q-card flat bordered>
      <q-card-section>
        <div class="text-h5">🎮 Gaming Leaderboard</div>
      </q-card-section>

      <q-separator />

      <!-- Top Players List -->
      <q-card-section>
        <div class="text-subtitle1">Top 10 Players</div>
        <q-list bordered padding>
          <q-item v-for="(player, index) in topPlayers" :key="player.id">
            <q-item-section>
              {{ index + 1 }}. {{ player.user.username }} — {{ player.totalScore }} pts
            </q-item-section>
          </q-item>
        </q-list>
      </q-card-section>

      <!-- Player Rank Lookup -->
      <q-card-section>
        <q-input v-model="lookupUserId" type="number" label="Check Player Rank by User ID" outlined />
        <q-btn color="primary" label="Get Rank" class="q-mt-sm" @click="getPlayerRank" />
        <div v-if="rankResult !== null" class="q-mt-sm">
          📊 User ID {{ rankResult.userId }} is ranked #{{ rankResult.rank }}
        </div>
      </q-card-section>

      <!-- Score Submission -->
      <q-card-section>
        <div class="text-subtitle1">Submit Score</div>
        <q-input v-model.number="submitUserId" type="number" label="User ID" outlined class="q-mb-sm" />
        <q-input v-model.number="submitScore" type="number" label="Score" outlined class="q-mb-sm" />
        <q-btn color="positive" label="Submit Score" @click="submitScoreToAPI" />
        <q-banner v-if="submitResponse" class="q-mt-sm bg-grey-2 text-primary">
          {{ submitResponse }}
        </q-banner>
      </q-card-section>
    </q-card>
  </q-page>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue';

const API_BASE = 'http://localhost:8080/api/leaderboard';

const topPlayers = ref([]);
const lookupUserId = ref('');
const rankResult = ref(null);
const submitUserId = ref(null);
const submitScore = ref(null);
const submitResponse = ref('');
let intervalId = null;

const fetchTopPlayers = async () => {
  try {
    const res = await fetch(`${API_BASE}/top`);
    topPlayers.value = await res.json();
  } catch (err) {
    console.error('Failed to fetch leaderboard:', err);
  }
};

const getPlayerRank = async () => {
  if (!lookupUserId.value) return;
  try {
    const res = await fetch(`${API_BASE}/rank/${lookupUserId.value}`);
    rankResult.value = await res.json();
  } catch (err) {
    console.error('Failed to fetch rank:', err);
  }
};

const submitScoreToAPI = async () => {
  if (!submitUserId.value || !submitScore.value) return;
  try {
    const res = await fetch(`${API_BASE}/submit`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        userId: submitUserId.value,
        score: submitScore.value
      })
    });
    if (res.ok) {
      submitResponse.value = '✅ Score submitted successfully!';
      fetchTopPlayers(); // refresh leaderboard
    } else {
      submitResponse.value = '❌ Failed to submit score.';
    }
  } catch (err) {
    console.error('Failed to submit score:', err);
    submitResponse.value = '❌ Error submitting score.';
  }
};

onMounted(() => {
  fetchTopPlayers();
  intervalId = setInterval(fetchTopPlayers, 5000);
});

onBeforeUnmount(() => {
  clearInterval(intervalId);
});
</script>

<style scoped>
.text-h5 {
  font-weight: bold;
}
</style>

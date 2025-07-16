import requests
import random
import time

# 🎯 Update this if your backend URL changes
API_BASE_URL = "http://localhost:8080/api/leaderboard"

# ✅ Config
NUM_REQUESTS = 1000            # Number of submissions
USER_ID_RANGE = (1, 10000)     # Random users between 1 and 10,000
SCORE_RANGE = (1000, 10000)    # Random scores
DELAY = 0.01                   # 10ms between requests

def submit_score(user_id, score):
    payload = {
        "userId": user_id,
        "score": score
    }

    try:
        response = requests.post(f"{API_BASE_URL}/submit", json=payload)
        if response.status_code == 200:
            print(f"✅ Submitted score {score} for user {user_id}")
        else:
            print(f"❌ Failed for user {user_id} - Status {response.status_code}")
    except Exception as e:
        print(f"⚠️ Error submitting score for user {user_id}: {e}")

def run_simulation():
    print(f"🚀 Starting load test: {NUM_REQUESTS} submissions\n")
    for _ in range(NUM_REQUESTS):
        user_id = random.randint(*USER_ID_RANGE)
        score = random.randint(*SCORE_RANGE)
        submit_score(user_id, score)
        time.sleep(DELAY)
    print("\n✅ Load test complete!")

if __name__ == "__main__":
    run_simulation()

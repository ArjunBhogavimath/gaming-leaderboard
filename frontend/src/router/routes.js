const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/LeaderboardPage.vue') }
    ]
  }
]

export default routes

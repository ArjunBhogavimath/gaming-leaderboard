import axios from 'axios'

export default ({ app }) => {
  // optional: inject into app.config.globalProperties
  app.config.globalProperties.$axios = axios
}

export { axios }

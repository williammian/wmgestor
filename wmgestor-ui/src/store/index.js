import Vuex from 'vuex'
// import Axios from 'axios'
import { store as products} from './../pages/products'
import { store as categories } from './../pages/categories'

// export default createStore({
//   state: {
//     count:0,
//     products:[]
//   },
//   mutations: {
//     increments(state){
//       state.count++
//     },
//     addProducts(state, payload){
//       state.products.push(payload)
//     }
//   },
//   actions: {
//      addProdutos({ commit } ,payload){
//           commit('addProducts', payload)
//      }
//   },
//   modules: {
//   }
// })

// const categories = {
//   state: {
//     categories:[]
//   }
// }

// const products = {
//   state: {
//     products:[]
//   },

//   mutations:{
//     getProductsM(state, payload){
//         state.products = payload
//     }
//   },

//   actions:{
//     getProducts({ commit }){
//       Axios.get('http://localhost:8081/products').then(resp => {
//         console.log(resp.data)
//         commit('getProductsM', resp.data )
//       })
//     }
//   }
// }

const store = new Vuex.Store({
  modules: {
    categories,
    products
  }
})

export default store
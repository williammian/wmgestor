import state from './state'
import mutations from './mutations'
import * as mutationsTypes from './mutation-types'
import * as actions from './actions'

export default {
    state,
    mutations,
    mutationsTypes,
    actions,
    namespaced:true
}
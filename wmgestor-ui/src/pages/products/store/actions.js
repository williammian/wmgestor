import * as types from "./mutation-types";
import Axios from "axios";

export const getProducts = ({ commit }) => {
  var token = localStorage.getItem("token");
  const headers = { Authorization: `Bearer ${token}` };
  Axios.get("http://localhost:8081/products", { headers }).then((resp) => {
    commit(types.GET_PRODUCTS, resp.data);
  });
};

export const addProducts = ({ commit }, add) => {
  var token = localStorage.getItem("token");
  const headers = { Authorization: `Bearer ${token}` };
  Axios.post("http://localhost:8081/products", add, { headers }).then((resp) => {
    commit(types.ADD_PRODUCTS, resp.data);
  });
};

export const findProductById = ({ commit }, id) => {
  var token = localStorage.getItem("token");
  const headers = { Authorization: `Bearer ${token}` };
  Axios.get("http://localhost:8081/products/" + id, { headers }).then(
    (resp) => {
      const dados = {
            id: resp.data.id,
            name:resp.data.name,
            amount:resp.data.amount,
            price:resp.data.price.toFixed(2),
            category:resp.data.category.id
      } 
      console.log(dados)
    commit(types.FIND_PRODUCTS, dados);
   
  });
};

export const updateProducts = ({ commit }, add) => {
  var token = localStorage.getItem("token");
  const headers = { Authorization: `Bearer ${token}` };
  Axios.put("http://localhost:8081/products/" + add.id, add, { headers }).then((resp) => {
    commit(types.UPDATE_PRODUCTS, resp.data);
  });
};

export const deleteProducts = ({ commit }, id) => {
  var token = localStorage.getItem("token");
  const headers = { Authorization: `Bearer ${token}` };
  Axios.delete("http://localhost:8081/products/" + id, { headers }).then((resp) => {
    commit(types.DELETE_PRODUCTS, resp.data);
  });
};

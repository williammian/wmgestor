<template>
  <div class="main">
    <h1>Novos Produtos</h1>
    <div class="form">
      <div class="row">
        <label for="">Descrição</label>
        <input v-model="form.name" class="ml-3" type="text" />
      </div>
      <div class="row">
        <label for="">Quantidade</label>
        <input v-model="form.amount" class="ml-3" type="text" />
      </div>
      <div class="row2">
        <label for="preço">Preço</label>
        <input
          v-model.lazy="price"
          v-money="money"
          type="text"
          class="ml-3"
        />
        <div class="row mt-3">
          <select id="categorias" v-model="form.category">
            <option v-for="categoria in categories.categories" :key="categoria.id" v-bind:value="categoria.id">
              {{ categoria.name }}
            </option>
          </select>
        </div>
      </div>
      <div class="botao">
        <button v-on:click="addProdutos" class="btn btn-primary">
          Cadastrar
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import { VMoney } from "v-money";

export default {
  directives: { money: VMoney },
  data() {
    return {
      form: {
        name: "",
        amount: "",
        category:''
      },
      price: 0,
      money: {
        decimal: ",",
        thousands: ".",
        prefix: "R$ ",
        suffix: "",
        precision: 2,
        masked: false /* doesn't work with directive */,
      },
    };
  },
  methods: {
    ...mapActions("products", ["addProducts"]),
    ...mapActions("categories", ["getCategories"]),

    addProdutos(add) {
      this.price = this.price.replace(/\./g, ""); //trocando o ponto dos milhares por nada
      this.price = this.price.slice(3).replace(",", "."); //retirando R$ e trocar a vírgula por ponto nas casas decimais
      add = {
        name: this.form.name,
        amount: this.form.amount,
        price: this.price,
        category: { id: parseInt(this.form.category)}
      };
      console.log(add)
      this.addProducts(add);
      this.form.name = "";
      this.form.amount = "";
      this.price = "";
    },
  },
  created() {
    this.getCategories();
  },
  computed: {
    ...mapState(["categories"]),
  },
};
</script>

<style lang="scss" scoped>
.main {
 
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  .form {
    display: flex;
    flex-direction: column;
    align-items: center;
    border: solid 1px gray;
    border-radius: 7%;
    width: 35%;
    padding: 1%;
    // padding-right: 0.5%;
    .row {
      width: 100%;
      padding: 1.4%;
      display: flex;
      align-items: baseline;
      justify-content: flex-start;
      label {
        align-items: flex-start;
        text-align: right;
        width: 21%;       
      }
      input {
        width: 69%;
        border: none;
        border-bottom: 1px solid grey;
      }
      input:focus {
        outline: none;
      }
    }
    .row2 {
      width: 100%;
      padding: 0.5%;
      display: flex;
      align-items: baseline;
      justify-content: space-between;
      margin-left: 10%;
      label {
        align-items: flex-start;
        text-align: right;
        width: 11%;       
      }
      input {
        width: 28%;
        border: none;
        border-bottom: 1px solid grey;
      }
      input:focus {
        outline: none;
      }
      #categorias {
        width: 70%;
        border: none;
        background-color: white;
        border-bottom: 1px solid grey;
        margin-left: 7%;              
        option{
          direction: rtl;
        }
      }
      #categorias:focus {
        outline: none;
      }
    }
  }
}
</style>

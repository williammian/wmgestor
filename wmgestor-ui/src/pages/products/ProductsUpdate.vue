<template>
  <div class="main" v-for="produto in products" :key="produto.id">
    <h4>Atualizar Produto</h4>
    <div class="alert alert-success" v-if="ok">
      <h4>Dados Atualizados com Sucesso!</h4>
    </div>
    <div class="alert" v-else-if="error">
      <h4>{{ message }}</h4>
    </div>

    <div v-if="produto.path" class="image">
      <img :src="'photos/' + produto.path" alt="">
    </div>

    <div class="form">
      <div class="row">
        <label for="">Descrição</label>
        <input v-model="produto.name" class="ml-3" type="text" />
      </div>
      <div class="row">
        <label for="">Quantidade</label>
        <input v-model="produto.amount" class="ml-3" type="text" />
      </div>
      <div class="row2">
        <label for="">Preço</label>
        <input
          v-model.lazy="produto.price"
          v-money="money"
          class="ml-3"
          type="text"
        />
        <div class="row mt-3">
          <select id="categorias" v-model="produto.category">
            <option v-for="categoria in categories.categories" :key="categoria.id" v-bind:value="categoria.id">
              {{ categoria.name }}
            </option>
          </select>
        </div>
      </div>
      <div class="botao">
        <button
          type="submit"
          v-on:click="updateProduto(produto, produto.price)"
          class="btn btn-warning"
        >
          Atualizar
        </button>
      </div>
    </div>
    <div class="upload">
      <router-link :to="{ name: 'upload', params: { id:produto.id } }">Upload</router-link>
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
      id: this.$route.params.id,
      message: "error",
      ok: false,
      error: false,
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

  computed: {
    ...mapState(["products"]),
    ...mapState(["categories"]),
  },
  methods: {
    ...mapActions("products", ["findProductById", "updateProducts"]),
    ...mapActions("categories", ["getCategories"]),

    async updateProduto(produto, preco) {
      preco = preco.replace(/\./g, "");
      preco = preco.slice(3).replace(",", ".");
      const update = {
        id: produto.id,
        name: produto.name,
        amount: produto.amount,
        price: preco,
        category: { id: produto.category }
      };
      console.log(update)
      try {
        await this.updateProducts(update);
        this.ok = true;
        await this.findProductById(produto.id);
      } catch (err) {
        err.data
          ? (this.message = err.data.message)
          : (this.message = "Não foi possível a atualização");
        this.error = true;
      }
    },
  },

  created() {
    this.getCategories();
    this.findProductById(this.$route.params.id);
  },

};
</script>

<style lang="scss" scoped>
.main {

  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  .image {
    max-width: 40%;
    img{
      max-width: 50%;
    }
  }  
  .form {
    display: flex;
    flex-direction: column;
    align-items: center;
    border: solid 1px gray;
    border-radius: 7%;
    width: 35%;
    padding: 1%;
    .row {
      width:100%;      
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

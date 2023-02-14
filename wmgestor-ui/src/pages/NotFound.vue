<template>
  <h2>404</h2>
  <h3>A página requerida não foi encontrada</h3>
  <button class="btn btn-primary" @click="voltar">Voltar a Home</button>
</template>

<script>
export default {

    methods:{
        voltar() {
            this.$router.push('/');
            //this.$router.go(-1); volta para a última página
        }
    }

}
</script>

<style>

</style>
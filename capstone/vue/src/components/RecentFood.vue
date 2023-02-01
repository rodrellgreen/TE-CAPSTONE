<template>
  <div>
      <ul>
          <li v-for="food in firstSevenFoods" :key="food"> {{food}} </li>

        
      </ul>
  </div>
</template>

<script>

export default {

    computed:{
        firstSevenFoods(){
            let food = [];
           for (let i = 0; i < 7; i++){
                food.unshift(this.$store.allFoods[i])
            }
            return food;
        }
    },

}
</script>

<style>

</style>
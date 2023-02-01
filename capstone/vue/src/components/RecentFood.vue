<template>
  <div>
      <ul v-for="food in firstSevenFoods" :key="food">
          <li >  {{food.foodItem}}  </li>

        
      </ul>
  </div>
</template>

<script>

export default {

    computed:{
        firstSevenFoods(){
            let food = [];
           for (let i = 0; i < 7; i++){
                food.push(this.$store.state.allFoods[i])
            }
            return food;
        }
    },

}
</script>

<style>

</style>
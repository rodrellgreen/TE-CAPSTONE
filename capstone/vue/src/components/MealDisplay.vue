<template>
  <div>
      <h1>Meal List</h1>
      <ul v-for="meal in meals" :key="meal">
          <li>{{meal.mealType}}</li>
          <button>Add Foods</button>
      </ul>
  </div>
</template>

<script>
import MealService from '../services/MealService.js';

export default {

    data() {
        return{
            meals: []
        }
    },

    created() {
       MealService.getMeals().then(
           (response) => {
               this.meals = response.data;
           }
       )
    }

}
</script>

<style>

</style>
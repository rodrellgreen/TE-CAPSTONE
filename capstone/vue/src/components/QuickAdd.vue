<template>
  <div>
      <h1> Quick Add Foods </h1>
      <form class="quick-add-form">
        <label for="quick-add-foods">Select a food to log:</label>
          <select id=quick-add-foods v-model="foodItem">
             <option v-for="food in quickAddFoods" :key="food">
              {{food.type}}
              calories: {{food.calories}}
              protein: {{food.protien}}
              carbs: {{food.carbs}}
              fiber: {{food.fiber}}
              fats: {{food.fats}}
              servings: {{food.servingSize}}
             </option>
          </select>
      </form>
      <button v-on:click="logFood">Log Food Item</button>
  </div>
</template>

<script>
import FoodService from '../services/FoodService.js';

export default {

    data() {
      return {

          quickAddFoods: [],

          foodItem: {}

      }
    },

    methods: {
      logFood() {
        window.alert(this.foodItem)
        FoodService.createFood(this.foodItem).then(
            (response) => {
                if(response.status === 201) {
                  alert("Success! Food Added.");
                  this.$router.push('/');
                  
                }
            } 
        );
      },

      addToFoodItems(event) {
        this.foodItems.push(event.target.value);
      }
    },

    created() {
         FoodService.getQuickAddFoods().then(
             (response) => {
                 this.quickAddFoods = response.data;
             }
        );
    }

}
</script>

<style>
  .quick-add-container {
    background-color: white;
    border: solid black 2px;
  }
</style>
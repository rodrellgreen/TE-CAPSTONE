<template>
  <div>
      <h1> Quick Add Foods </h1>
      <!-- Load quick add foods -->
      <!-- display whole food item object -->
      <!-- Make them clickable; clicking calls log food method which calls food service method :) -->
      <ul v-for="food in quickAddFoods" :key="food">
          <li class="quick-add-container" v-on:click="logFood" >
              {{food.type}}
              calories: {{food.calories}}
              protein: {{food.protien}}
              carbs: {{food.carbs}}
              fiber: {{food.fiber}}
              fats: {{food.fats}}
              servings: {{food.servingSize}}
          </li>
      </ul>
  </div>
</template>

<script>
import FoodService from '../services/FoodService.js';

export default {

    data() {
      return {

            quickAddFoods: [],

            foodItem: {
                type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null,
                servingSize: null, 
                quickAdd: null,
                date: null,
            }
      }
    },

    methods: {
        logFood() {
          FoodService.createFood(this.foodItem).then(
              (response) => {
                  if(response.status === 201) {
                    alert("Success! Food Added.");
                    this.$router.push('/');
                  
                  }
            } 
          );
      },
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
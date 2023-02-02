<template>
  <div>
      <h1> Quick Add Foods </h1>
      <form class="quick-add-form" v-for="food in quickAddFoods" v-bind:key="food">
        <input type="checkbox" v-bind:value="food.type" v-on:change="addToFoodItem($event)">
         <div class="quick-add-container">
          {{food.type}}
          Calories: {{food.calories}}
          Protein: {{food.protein}}
          Carbs: {{food.carbs}}
          Fat: {{food.fats}}
          Fiber: {{food.fiber}}
          Serving Size: {{food.servingSize}}
         </div>
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

      addToFoodItem(event) {
        if(this.foodItem.type !== event.target.value) {
          for(let i=0; i<this.quickAddFoods.length; i++) {
            if(this.quickAddFoods[i].type == event.target.value) {
              this.foodItem.type = this.quickAddFoods[i].type;
              this.foodItem.calories = this.quickAddFoods[i].calories;
              this.foodItem.carbs = this.quickAddFoods[i].carbs;
              this.foodItem.protein = this.quickAddFoods[i].protein;
              this.foodItem.fats = this.quickAddFoods[i].fats;
              this.foodItem.fiber = this.quickAddFoods[i].fiber;
              this.foodItem.servingSize = this.quickAddFoods[i].servingSize;
              this.foodItem.quickAdd = this.quickAddFoods[i].quickAdd;
              this.foodItem.date = this.quickAddFoods[i].date;
            }
          }
        }
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
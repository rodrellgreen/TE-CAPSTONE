<template>
  <div class="container">
      <h1>Meal List</h1>
      <div class="meal-container">
      <ul v-for="meal in meals" :key="meal">
          <li>{{meal.mealType}}</li>
          <button v-on:click="showAddFood = !showAddFood, mealType=meal.mealType" v-if="!showAddFood">Add Food</button>
          <button v-on:click="showAddFood = !showAddFood" v-else>Cancel</button>
          <button v-on:click="removeMeal(meal.mealId)">Remove Meal</button>
          <button>Edit</button>
          <button>Log</button>
      </ul>
      <form class="add-food-form" v-if="showAddFood">
        <h3>{{mealType}}</h3>
        <label for="food">Food:</label>
        <input id="food" type="text" class="input-box" required/>
        <label for="calories">Calories:</label>
        <input id="calories" type="number" class="input-box" required/>
        <label for="protein">Protein:</label>
        <input id="protein" type="number" class="input-box"/>
        <label for="carbs">Carbs:</label>
        <input id="carbs" type="number" class="input-box"/>
        <label for="fiber">Fiber:</label>
        <input id="fiber" type="number" class="input-box"/>
        <label for="fat">Fat:</label>
        <input id="fat" type="number" class="input-box"/>
        <button>Add</button>
      </form>
      </div>
  </div>
</template>

<script>
import MealService from '../services/MealService.js';

export default {

    data() {
        return{
            meals: [],
            showAddFood: false,
            mealType: ""
        }
    },

    created() {
       MealService.getMeals().then(
           (response) => {
               this.meals = response.data;
           }
       )
    },

    methods: {
        removeMeal(id) {
            MealService.deleteMeal(id).then(
                (response) => {
                    if(response.status === 200) {
                        alert("Meal removed from list.");
                        this.$router.go();
                    }
                }
            );
        },
        // addFoodToMeal(id, meal) {
        //     MealService.addFoodToMeal()
        // }
    }

}
</script>

<style scoped>
    button {
        margin: 10px;
        padding: 3px;
        border: solid grey 1px;
        border-radius: 5px;
        background-color: yellow;
    }

    .input-box {
        border: solid black 1px;
    }

    .container {
        border: solid black 2px;
        border-radius: 10px;
    }

    ul {
        list-style: none;
    }

</style>
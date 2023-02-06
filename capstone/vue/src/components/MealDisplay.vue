<template>
  <div class="container">
      <h1>Meal List</h1>
      <div class="meal-container">
      <ul v-for="meal in meals" :key="meal.mealId">
          <li>{{meal.mealType}}</li>
          <button v-on:click="showAddFood = !showAddFood, mealType=meal.mealType, mealId=meal.mealId" v-if="!showAddFood">Add Food</button>
          <button v-on:click="showAddFood = !showAddFood" v-else>Cancel</button>
          <button v-on:click="removeMeal(meal.mealId)">Remove Meal</button>
          <button v-if="!addDate" v-on:click="getFoods(meal)">Log</button>
          <button v-if="addDate" v-on:click="addDate=!addDate">Cancel</button>
      </ul>
      <form class="add-food-form" v-if="showAddFood">
        <h3>{{mealType}}</h3>
        <h3>{{mealId}}</h3>
        <label for="food">Food:</label>
        <input v-model="foodItem.type" id="food" type="text" class="input-box" required/>
        <label for="calories">Calories:</label>
        <input v-model="foodItem.calories" id="calories" type="number" class="input-box" required/>
        <label for="protein">Protein:</label>
        <input v-model="foodItem.protein" id="protein" type="number" class="input-box"/>
        <label for="carbs">Carbs:</label>
        <input v-model="foodItem.carbs" id="carbs" type="number" class="input-box"/>
        <label for="fiber">Fiber:</label>
        <input v-model="foodItem.fiber" id="fiber" type="number" class="input-box"/>
        <label for="fat">Fat:</label>
        <input v-model="foodItem.fat" id="fat" type="number" class="input-box"/>
        <label for="serving-size">Serving Size:</label>
        <input v-model="foodItem.servingSize" id="serving-size" type="number" class="input-box"/>
        <button v-on:click="addFoodToMeal">Add</button>
      </form>
      <form v-if="addDate" @submit.prevent="logMeal">
          <label for="date">Please enter date:</label>
          <input id="date" type="date" v-model="foodItem.date"/>
          <button>Log</button>
      </form>
      </div>
  </div>
</template>

<script>
import MealService from '../services/MealService.js';
import FoodService from '../services/FoodService.js';

export default {

    data() {
        return{
            meals: [],
            showAddFood: false,
            addDate: false,
            mealType: "",
            mealId: null,
            foodItem: {
                type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null,
                servingSize: null, 
                quickAdd: false,
                date: "",
            },
            foods: []
        }
    },

    created() {
       MealService.getMeals().then(
           (response) => {
               this.meals = response.data;
           }
       );
       MealService.getFoods(3).then(
                (response) => {
                    this.foods = response.data;
                }
            );
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
        addFoodToMeal() {
            MealService.addFoodToMeal(this.mealId, this.foodItem).then(
                (response) => {
                    if(response.status === 201) {
                        alert(`Success! ${this.foodItem.type} added to meal`);
                        this.$router.go();
                    }
                }
            );
        },
        logMeal() {
            var strInputValue = this.foodItem.date; // <-- get my date string
            let strInputValue2 = strInputValue
                .replace(/-/, "/") // replace 1st "-" with "/"
                .replace(/-/, "/"); // replace 2nd "-" with "/"
            this.foodItem.date = new Date(strInputValue2);
            this.foods.push()
            alert(`${this.foods}`);
            alert(`${this.foodItem.date}`);
            
            for(let i=0; i<this.foods.length; i++) {
                this.foods[i].date = this.foodItem.date;
                FoodService.createFood(this.foods[i]);
            }
        },
        getFoods(meal) {
            this.mealId=meal.mealId;
            this.showAddFood=false;
            this.addDate=!this.addDate;
            MealService.getFoods(this.mealId).then(
                (response) => {
                    this.foods = response.data;
                }
            );
        }
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
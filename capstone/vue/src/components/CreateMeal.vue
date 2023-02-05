<template>
  <div class="meal-form-container">
      <h1>Create New Meal</h1>
      <form class="meal-form">
          <label for="name">Meal Name:</label>
          <input
            type="text"
            id="name"
            class="input-box"
            placeholder="Ex: Spaghetti"
            v-model="newMealName"
            required
            autofocus
        />
      </form>
  </div>
</template>

<script>
import MealService from '../services/MealService.js';

export default {

    data() {
        return {

            newMealName: ""

        }
    },

    methods: {
        createMeal() {
            MealService.createMeal(this.newMealName).then(
                (response) => {
                    if(response.status === 201) {
                        alert("Success! Meal created");
                        this.$router.go();
                    }
                }
            ); 
        },

    }

}
</script>

<style>

</style>
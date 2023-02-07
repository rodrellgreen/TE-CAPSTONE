<template>
  <div class="meal-form-container">
    <!-- <h1>Create New Meal</h1> -->
    <form class="meal-form" @submit.prevent="createMeal">
      <label for="name">Meal Name:</label>
      <input
        type="text"
        id="name"
        class="input-box"
        placeholder="Ex: Spaghetti"
        v-model="mealObj.mealType"
        required
        autofocus
      />
      <button class="create-meal-btn" type="submit">Add</button>
    </form>
  </div>
</template>

<script>
import MealService from "../services/MealService.js";

export default {
  data() {
    return {
      mealObj: {
        mealType: "",
      },
    };
  },

  methods: {
    createMeal() {
      MealService.createMeal(this.mealObj).then((response) => {
        if (response.status === 201) {
          alert(`Success! ${this.mealObj.mealType} created`);
          this.$router.go();
        }
      });
    },
  },
};
</script>

<style>
</style>
<template>
  <v-container form-container>
      <CreateMeal/>
      <MealDisplay/>
  </v-container>
</template>

<script>
import CreateMeal from '../components/CreateMeal.vue';
import MealDisplay from '../components/MealDisplay.vue';

export default {

    components: {
        CreateMeal,
        MealDisplay
    }

}
</script>

<style>

</style>
<template>
  <div id="foodLogTable" style="overflow-x: auto">
    <table id="food-log">
      <caption class="tableHeader">
        Food Log
      </caption>
      <tbody>
        <tr>
          <th>Date</th>
          <th>Food</th>
          <th>Calories</th>
          <th>Carbs</th>
          <th>Protein</th>
          <th>fats</th>
          <th>fiber</th>
          <th>Servings</th>
          <th>Edit Food</th>
        </tr>
        <tr v-for="food in sortedFood" :key="food">
          <td>{{ food.date }}</td>
          <td>{{ food.type }}</td>
          <td>{{ food.calories }}</td>
          <td>{{ food.carbs }}</td>
          <td>{{ food.protein }}</td>
          <td>{{ food.fats }}</td>
          <td>{{ food.fiber }}</td>
          <td>{{ food.servingSize }}</td>

          <v-btn
            class="editFoodEntry"
            v-on:click="startUpdate(food)"
            v-bind="food.id"
            >Edit</v-btn
          >
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import FoodService from "../services/FoodService.js";
export default {
  methods: {
    startUpdate(food) {
      this.$store.state.updateFoodItem = !this.$store.state.updateFoodItem;
      this.$store.state.foodItemToUpdate = food;
    },
  },
  data() {
    return {
      foodLog: [],
      updateFoodItem: false,
    };
  },
  created() {
    FoodService.getAllFoods().then((response) => {
      this.foodLog = response.data;
    });
  },

  computed: {
    sortedFood() {
      return [...this.foodLog].sort((a, b) => {
        const dateA = new Date(a.date);
        const dateB = new Date(b.date);
        if (dateA > dateB) {
          return -1;
        }
        if (dateA < dateB) {
          return 1;
        }
        return this.foodLog.indexOf(b) - this.foodLog.indexOf(a);
      });
    },
    streak() {
      let streak = 0;
      let newDate = new Date(this.sortedFood[0].date);
      let oldDate = new Date(this.sortedFood[1].date);
      if (newDate.getDate() == oldDate.getDate() + 1) {
        streak++;
      } else {
        streak = 0;
      }
      return streak;
    },
  },
};
</script>

<style>
</style>
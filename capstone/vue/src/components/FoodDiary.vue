<template>
  <div id="foodLogTable">



<table  id="food-log">
<thead> <td> Food Log </td></thead>
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
    
  </tr>
  <tr v-for="food in sortedFood" :key="food.date">
    <td>{{this.food.type}}</td>
    <td>{{this.food.calories}}</td>
    <td>{{this.food.carbs}}</td>
    <td>{{this.food.protein}}</td>
    <td>{{this.food.fats}}</td>
    <td>{{this.food.fiber}}</td>
    <td>{{this.food.servingSize}}</td>
    <td>{{this.food.date}}</td>


    
    
  </tr>
</tbody>
 
</table>

</div>
</template>

<script>
import FoodService from '../services/FoodService.js'
export default {
    data() {
        return {
            foodLog: []
        }
    },
     created() {
        FoodService.getAllFoods().then(
            (response) => {
                this.foodLog = response.data;
            }
        )
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
        
}

}
   
</script>

<style>

</style>
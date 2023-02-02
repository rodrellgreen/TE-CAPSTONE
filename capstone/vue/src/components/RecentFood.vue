<template>
  <body>

<h1>Recent Foods</h1>

<table  id="food-log">
  <tr>
    <th>Food</th>
    <th>Calories</th>
    <th>Carbs</th>
    <th>Protein</th>
    <th>fats</th>
    <th>fiber</th>
    <th>Servings</th>
    <th>Date</th>
  </tr>
  <tr v-for="food in foodLog" :key="food">
    <td>{{food.date}}</td>
    <td>{{food.type}}</td>
    <td>{{food.calories}}</td>
    <td>{{food.carbs}}</td>
    <td>{{food.protein}}</td>
    <td>{{food.fats}}</td>
    <td>{{food.fiber}}</td>
    <td>{{food.servingSize}}</td>

    
    
  </tr>
 
</table>

</body>
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
    }
}
   
</script>


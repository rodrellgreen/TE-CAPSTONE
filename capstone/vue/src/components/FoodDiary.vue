<template>
  <body>

<h1>Food Log</h1>

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

<style>
#food-log {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#food-log td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#food-log tr:nth-child(even){background-color: #f2f2f2;}

#food-log tr:hover {background-color: #ddd;}

#food-log th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
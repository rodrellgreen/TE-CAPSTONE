<template>
  <v-card
    class="mt-4 mx-auto"
    max-width="400"
  >
    <v-sheet
      class="v-sheet--offset mx-auto"
      color="cyan"
      elevation="12"
      max-width="calc(100% - 32px)"
    >
      <v-sparkline
        :labels="labels"
        :calories="this.calorieLogLastWeek()" 
        color="white"
        line-width="2"
        padding="16"
      ></v-sparkline>
    </v-sheet>

    <v-card-text class="pt-0">
      <div class="text-h6 font-weight-light mb-2">
        User Registrations
      </div>
      <div class="subheading font-weight-light grey--text">
        Last Campaign Performance
      </div>
      <v-divider class="my-2"></v-divider>
      <v-icon
        class="mr-2"
        small
      >
        mdi-clock
      </v-icon>
      <span class="text-caption grey--text font-weight-light">last registration 26 minutes ago</span>
    </v-card-text>
  </v-card>
</template>

<script>
import FoodService from '../services/FoodService.js'

  export default {
    data() {
        return {
      allFoods: [],
      }
     
    },
    created() {
        FoodService.getAllFoods().then(
            (response) => {
              this.allFoods = response.data;
            }
        )
        
    },

    computed: {
        // whatever(){
          
        // },
        calorieLogLastWeek() {
        let now = new Date();
        let lastWeek = new Date(now.getTime() - 7 * 24 * 60 * 60 * 1000);
        console.log('new date variable lastWeek:',lastWeek)
         console.log('allFoods:', this.allFoods); 
    
        let result = this.foodLog
        console.log('Date: ', this.foodLog.date)
        // console.log('are these dates:',new Date(this.foodLog.date))
        // console.log('are these numbers:', this.foodLog.calories)
        // console.log('are these strings:', this.foodLog.type)
        result.filter(food => new Date(food.date) > lastWeek)
        
        .map(food => food.calories);
        // console.log('what is this:', this.foodLog)
        console.log('Calorie Result:', result.calories);
      return result;
    },
  
},
  }
</script>

<style>
  .v-sheet--offset {
    top: -24px;
    position: relative;
  }
</style>
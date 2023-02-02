<template>
<div id="form-container" class="form-container">
    <form class="form-form" @submit="logFood" action="">
        <h1>Log Food</h1>
        
        <div class="flex-container">
            <label class="input-label" for="name">Food</label>
            <input class="input-box" id="name" type="text" v-model="foodItem.type" required placeholder="Ex: Potato">
        </div>
        <div class="flex-container">
            <label class="input-label" for="calories">Calories</label>
            <input class="input-box" id="calories" type="number" v-model="foodItem.calories" required placeholder="Ex: 163">
        </div>
        <div class="flex-container">
            <label class="input-label" for="carbs">Carbs</label>
            <input class="input-box" id="carbs" type="number" v-model="foodItem.carbs" required placeholder="Ex: 37">
        </div>
        <div class="flex-container">
            <label class="input-label" for="protein">Protien</label>
            <input class="input-box" id="protein" type="number" v-model="foodItem.protein" required placeholder="Ex: 4">
        </div>
        <div class="flex-container">
            <label class="input-label" for="fats">Fats</label>
            <input class="input-box" id="fats" type="number" v-model="foodItem.fats" required placeholder="Ex: 0">
        </div>
        <div class="flex-container">
            <label class="input-label" for="fiber">Fiber</label>
            <input class="input-box" id="fiber" type="number" v-model="foodItem.fiber" required placeholder="Ex: 5">
        </div>
        
        <div class="flex-container">
            <label class="input-label" for="servings">Serving</label>
            <input class="input-box" id="servings" type="number" v-model="foodItem.servingSize" required placeholder="Ex: 1">
        </div>

        <div class="flex-container">
            <label class="input-checkbox" for="quick-add">Enable "Quick Add"</label>
            <input id="quick-add" type="checkbox" v-model="foodItem.quickAdd">
            
        </div>

        <div class="flex-container">
            <label class="input-label"  for="date">Date</label>
            <input class="input-box" id="date" type="date" v-model="foodItem.date" required placeholder="Ex: 1">
        </div>
        
        
        <h3 v-if="showOptions" @close="showOptions = false">
            Would you like to add to Snack, Breakfeast, Lunch, or Dinner?
            <div>
                <button v-on:click="addNewSnack"> Snack </button>
                <button v-on:click="addNewBreakfeast"> Breakfeast </button>
                <button v-on:click="addNewLunch"> Lunch </button>
                <button v-on:click="addNewDinner"> Dinner </button>
            </div>
        </h3>
        
    </form>
    </div>
</template>

<script>
import FoodService from '../services/FoodService';
export default {
    

    data() {
        return{
            
            foodItemDate: '',

            foodItem: {
                type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null,
                servingSize: null, 
                quickAdd: null,
                date: null,
            }
        }
    },

   watch: {
  foodItemDate(newDate) {
      
    this.foodItem.date = new Date(newDate).toJSON();
    // console.log(this.foodItemDate)
  }
},
    // created(){
    //     FoodService.createFood(this.foodItem).then(

    //         (response) => {
    //             if(response.status == 200){
    //                 this.$router.push('/')
    //             }
                
    //         }
    //     )
    // },

    computed: {
        showOptions(){
            if(this.foodItem.type && this.foodItem.calories && this.foodItem.carbs && this.foodItem.protein
          && this.foodItem.fats && this.foodItem.fiber && this.foodItem.servingSize){
              return true;
          } else {
              return false;
          }
        },
    },

    methods:{

     logFood() {
         var strInputValue = this.foodItem.date; // <-- get my date string
    

        let strInputValue2 = strInputValue.replace(/-/, '/')  // replace 1st "-" with "/"
                                      .replace(/-/, '/'); // replace 2nd "-" with "/"

        this.foodItem.date = new Date(strInputValue2);
        alert(this.foodItem.date)
          FoodService.createFood(this.foodItem).then(
              (response) => {
                  if(response.status === 201) {
                    alert("Success! Food Added.");
                    this.$router.push('/');
                  
                  }
            } 
          );
      },
    },


       addNewSnack(){
     
           this.foodItem.calories = (this.foodItem.calories - this.foodItem.fiber) * this.foodItem.servingSize;
           this.foodItem.carbs = this.foodItem.carbs * this.foodItem.servingSize;
           this.foodItem.protein = this.foodItem.protein * this.foodItem.servingSize;
           this.foodItem.fats = this.foodItem.fats * this.foodItem.servingSize;  
           this.foodItem.fiber = this.foodItem.fiber * this.foodItem.servingSize;
           this.$store.commit('NEW_SNACK', this.foodItem)
           this.$store.commit('NEW_ALLFOODS', this.foodItem)
           this.foodItem = {  type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null, 
                servingSize: null,
                date_entered: null,
           }
       },

        addNewBreakfeast(){
      
           this.foodItem.calories = (this.foodItem.calories - this.foodItem.fiber) * this.foodItem.servingSize;
           this.foodItem.carbs = this.foodItem.carbs * this.foodItem.servingSize;
           this.foodItem.protein = this.foodItem.protein * this.foodItem.servingSize;
           this.foodItem.fats = this.foodItem.fats * this.foodItem.servingSize;  
           this.foodItem.fiber = this.foodItem.fiber * this.foodItem.servingSize;
           this.$store.commit('NEW_BREAKFEAST', this.foodItem)
           this.$store.commit('NEW_ALLFOODS', this.foodItem)
           this.foodItem = {  type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null, 
                servingSize: null,
                date_entered: null,
           }
       },

        addNewLunch(){
           
           this.foodItem.calories = (this.foodItem.calories - this.foodItem.fiber) * this.foodItem.servingSize;
           this.foodItem.carbs = this.foodItem.carbs * this.foodItem.servingSize;
           this.foodItem.protein = this.foodItem.protein * this.foodItem.servingSize;
           this.foodItem.fats = this.foodItem.fats * this.foodItem.servingSize;  
           this.foodItem.fiber = this.foodItem.fiber * this.foodItem.servingSize;
           this.$store.commit('NEW_LUNCH', this.foodItem)
           this.$store.commit('NEW_ALLFOODS', this.foodItem)
           this.foodItem = {  type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null, 
                servingSize: null,
                date_entered: null,
           }

       },

        addNewDinner(){
           
           this.foodItem.calories = (this.foodItem.calories - this.foodItem.fiber) * this.foodItem.servingSize;
           this.foodItem.carbs = this.foodItem.carbs * this.foodItem.servingSize;
           this.foodItem.protein = this.foodItem.protein * this.foodItem.servingSize;
           this.foodItem.fats = this.foodItem.fats * this.foodItem.servingSize;  
           this.foodItem.fiber = this.foodItem.fiber * this.foodItem.servingSize;
           this.$store.commit('NEW_DINNER', this.foodItem)
           this.$store.commit('NEW_ALLFOODS', this.foodItem)
           this.foodItem = {  type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null, 
                servingSize: null,
                date_entered: null,
           }
          
       },
        
    
}
</script>


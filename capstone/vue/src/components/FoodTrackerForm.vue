<template>
    <form @submit="logFood" class="food" action="">
        <ul class="flex-outer">
            <li><h1> Log Food </h1> </li>
        
        <li>
            <label for="name">Food</label>
            <input id="name" type="text" v-model="foodItem.type" required placeholder="Ex: Potato">
        </li>
        <li>
            <label for="calories">Calories</label>
            <input id="calories" type="number" v-model="foodItem.calories" required placeholder="Ex: 163">
        </li>
        <li>
            <label for="carbs">Carbs</label>
            <input id="carbs" type="number" v-model="foodItem.carbs" required placeholder="Ex: 37">
        </li>
        <li>
            <label for="protein">Protien</label>
            <input id="protein" type="number" v-model="foodItem.protein" required placeholder="Ex: 4">
        </li>
        <li>
            <label for="fats">Fats</label>
            <input id="fats" type="number" v-model="foodItem.fats" required placeholder="Ex: 0">
        </li>
        <li>
            <label for="fiber">Fiber</label>
            <input id="fiber" type="number" v-model="foodItem.fiber" required placeholder="Ex: 5">
        </li>
        
        <li>
            <label for="servings">Serving</label>
            <input id="servings" type="number" v-model="foodItem.servingSize" required placeholder="Ex: 1">
        </li>

        <li>
            <label for="quick-add">Add to "Quick Add" List</label>
            <input id="quick-add" type="checkbox">
        </li>

        <li>
            <label for="date">Date</label>
            <input id="date" type="date" v-model="foodItem.date" required placeholder="Ex: 1">
        </li>
        

       </ul>
        
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
    
</template>

<script>
import FoodService from '../services/FoodService';
export default {
    

    data() {
        return{
            
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


<template>
    <form action="">
        <!-- <header> Meeting Goals Together </header> -->
        <div>
             Food <input type="text" v-model="foodItem.type" required>
        </div>
       <div>
           Calories <input type="number" v-model="foodItem.calories" required>
       </div>
        <div>
            Carbs <input type="number" v-model="foodItem.carbs" required>
        </div>
        <div>
            Protien <input type="number" v-model="foodItem.protein" required>
        </div>
        <div>
            Fats <input type="number" v-model="foodItem.fats" required>
        </div>
        <div>
            Fiber <input type="number" v-model="foodItem.fiber" required> 
        </div>
        <div>
            Serving Size <input type="number" v-model="foodItem.servingSize" required>
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
    
</template>

<script>
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
            }
        }
    },

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

        

       addNewSnack(){
     
           this.foodItem.calories = (this.foodItem.calories - this.foodItem.fiber) * this.foodItem.servingSize;
           this.foodItem.carbs = this.foodItem.carbs * this.foodItem.servingSize;
           this.foodItem.protein = this.foodItem.protein * this.foodItem.servingSize;
           this.foodItem.fats = this.foodItem.fats * this.foodItem.servingSize;  
           this.foodItem.fiber = this.foodItem.fiber * this.foodItem.servingSize;
           this.$store.commit('NEW_SNACK', this.foodItem)
           this.foodItem = {  type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null, 
                servingSize: null,
           }
       },

        addNewBreakfeast(){
      
           this.foodItem.calories = (this.foodItem.calories - this.foodItem.fiber) * this.foodItem.servingSize;
           this.foodItem.carbs = this.foodItem.carbs * this.foodItem.servingSize;
           this.foodItem.protein = this.foodItem.protein * this.foodItem.servingSize;
           this.foodItem.fats = this.foodItem.fats * this.foodItem.servingSize;  
           this.foodItem.fiber = this.foodItem.fiber * this.foodItem.servingSize;
           this.$store.commit('NEW_BREAKFEAST', this.foodItem)
           this.foodItem = {  type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null, 
                servingSize: null,
           }
       },

        addNewLunch(){
           
           this.foodItem.calories = (this.foodItem.calories - this.foodItem.fiber) * this.foodItem.servingSize;
           this.foodItem.carbs = this.foodItem.carbs * this.foodItem.servingSize;
           this.foodItem.protein = this.foodItem.protein * this.foodItem.servingSize;
           this.foodItem.fats = this.foodItem.fats * this.foodItem.servingSize;  
           this.foodItem.fiber = this.foodItem.fiber * this.foodItem.servingSize;
           this.$store.commit('NEW_LUNCH', this.foodItem)
           this.foodItem = {  type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null, 
                servingSize: null,
           }

       },

        addNewDinner(){
           
           this.foodItem.calories = (this.foodItem.calories - this.foodItem.fiber) * this.foodItem.servingSize;
           this.foodItem.carbs = this.foodItem.carbs * this.foodItem.servingSize;
           this.foodItem.protein = this.foodItem.protein * this.foodItem.servingSize;
           this.foodItem.fats = this.foodItem.fats * this.foodItem.servingSize;  
           this.foodItem.fiber = this.foodItem.fiber * this.foodItem.servingSize;
           this.$store.commit('NEW_DINNER', this.foodItem)
           this.foodItem = {  type: "",
                calories: null,
                carbs: null,
                protein: null,
                fats: null,
                fiber: null, 
                servingSize: null,
           }
          
       },
        
    },
}
</script>

<style>

</style>
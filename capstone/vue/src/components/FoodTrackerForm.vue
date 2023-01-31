<template>
    <form action="">
        <!-- <header> Meeting Goals Together </header> -->
        <div>
             Food Type <input type="text" v-model="foodItem.type" required>
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
        <div>
            <button v-on:click.prevent="addNewFood"> Submit </button>
            
        </div>
    </form>
    
</template>

<script>
export default {
    

    data() {
        return{
            foodItem: {
                type: "",
                calories: 0,
                carbs: 0,
                protein: 0,
                fats: 0,
                fiber: 0,
                servingSize: 0, 
            }
        }
    },

    methods:{
       addNewFood(){
           
           this.foodItem.calories = (this.foodItem.calories - this.foodItem.fiber) * this.foodItem.servingSize;
           this.foodItem.carbs = this.foodItem.carbs * this.foodItem.servingSize;
           this.foodItem.protein = this.foodItem.protein * this.foodItem.servingSize;
           this.foodItem.fats = this.foodItem.fats * this.foodItem.servingSize;  
           this.foodItem.fiber = this.foodItem.fiber * this.foodItem.servingSize;
           this.$store.commit('NEW_FOOD', this.foodItem)
           this.foodItem = {  type: "",
                calories: 0,
                carbs: 0,
                protein: 0,
                fats: 0,
                fiber: 0, 
                servingSize: 0,
           }
       }
        
    },
}
</script>

<style>

</style>
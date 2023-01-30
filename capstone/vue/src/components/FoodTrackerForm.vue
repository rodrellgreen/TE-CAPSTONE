<template>
    <form action="">
        <!-- <header> Meeting Goals Together </header> -->
        <div>
             Food Type <input type="text">
        </div>
       <div>
           Calories <input type="number">
       </div>
        <div>
            Carbs <input type="number">
        </div>
        <div>
            Protien <input type="number">
        </div>
        <div>
            Fats <input type="number">
        </div>
        <div>
            Fiber <input type="number">
        </div>
        <div>
            <button> Submit </button>
            <button> Add to Quick add</button>
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
                Protein: 0,
                fats: 0,
                Fiber: 0, 
            }
        }
    },

    methods:{
       
        
    },
}
</script>

<style>

</style>
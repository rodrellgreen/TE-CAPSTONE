<template>

  <div class="food-tracker">
        
        <food-tracker-form v-if="!showQuickAdd"/>
        <quick-add v-if="showQuickAdd"/>
        <router-link v-bind:to="{name: 'meals'}">Quick Meals</router-link>
        <button v-if="!showQuickAdd" v-on:click="showQuickAdd = !showQuickAdd">Quick Add</button>
        <button v-if="showQuickAdd" v-on:click="showQuickAdd = !showQuickAdd">Cancel</button>
       <food-diary/>
        
       <update-food v-if="$store.state.updateFoodItem" />
</div>

    
</template>


<script>
import FoodDiary from '../components/FoodDiary.vue'
import FoodTrackerForm from '../components/FoodTrackerForm.vue'
import QuickAdd from '../components/QuickAdd.vue';
import UpdateFood from '../components/UpdateFood.vue';


export default {

    data() {
        return {
            showQuickAdd: false,
            updateFoodItem: false
        }
    },

    name: 'food',
    components:{
        FoodTrackerForm,
        FoodDiary,
        QuickAdd,
        UpdateFood,
    }
}
</script>

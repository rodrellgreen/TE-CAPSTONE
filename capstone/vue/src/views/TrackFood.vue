<template>

  <div class="food-tracker">
        <food-tracker-form v-if="!showQuickAdd"/>
        <quick-add v-if="showQuickAdd"/>
        <button v-if="!showQuickAdd" v-on:click="showQuickAdd = !showQuickAdd">Quick Add</button>
        <button v-if="showQuickAdd" v-on:click="showQuickAdd = !showQuickAdd">Cancel</button>
       <food-diary/>
</div>

    
</template>


<script>
import FoodDiary from '../components/FoodDiary.vue'
import FoodTrackerForm from '../components/FoodTrackerForm.vue'
import QuickAdd from '../components/QuickAdd.vue';


export default {

    data() {
        return {
            showQuickAdd: false
        }
    },

    name: 'food',
    components:{
        FoodTrackerForm,
        FoodDiary,
        QuickAdd
    }
}
</script>

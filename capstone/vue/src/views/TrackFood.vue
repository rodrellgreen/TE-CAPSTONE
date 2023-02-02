
<template>

  <div class="food-tracker">
        <food-tracker-form/>

       <food-diary/>

        <quick-add/>
</div>

    
</template>


<script>
import FoodDiary from '../components/FoodDiary.vue'
import FoodTrackerForm from '../components/FoodTrackerForm.vue'
import QuickAdd from '../components/QuickAdd.vue';


export default {
    name: 'food',
    components:{
        FoodTrackerForm,
        FoodDiary,
        QuickAdd
    }
}
</script>

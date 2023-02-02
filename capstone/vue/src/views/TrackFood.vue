
<template>
    <div class="food-tracker">
       <food-tracker-form/> <food-diary/>
       
    </div>
    
</template>


<script>
import FoodDiary from '../components/FoodDiary.vue'
import FoodTrackerForm from '../components/FoodTrackerForm.vue'


export default {
    name: 'food',
    components:{
        FoodTrackerForm,
        FoodDiary
        
    }
}
</script>



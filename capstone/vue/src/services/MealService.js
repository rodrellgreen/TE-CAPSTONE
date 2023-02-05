import axios from 'axios';

export default {

    createMeal(mealType) {
        return axios.post(`/meals/${mealType}`, mealType);
    },

    addFoodToMeal(id, meal) {
        return axios.post(`/meals/${id}`, meal)
    },

    getMeals() {
        return axios.get('/meals');
    },

    updateMealType(meal) {
        return axios.put('/meals', meal);
    },

    updateMealFood(id, meal) {
        return axios.put(`/meals/${id}`, meal);
    },

    deleteMeal(id) {
        return axios.delete(`/meals/${id}`);
    }

}
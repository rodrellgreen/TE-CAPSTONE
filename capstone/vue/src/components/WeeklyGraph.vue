<template>
  <div>
    <JSCharting :options="options" style="height: 400px"></JSCharting>
    <button v-on:click="updateData">Update Chart Data</button>
  </div>
</template>

<script>
import JSCharting from "jscharting-vue";
// import FoodService from "../services/FoodService.js";

export default {
  name: "methodUpdate",
  data() {
    let options = {
      type: "line spline",
      title: { label: { text: "Series updates" } },
      legend: {
        position: "inside top right",
      },
      xAxis: { scale: { type: "time" } },
      yAxis: { scale: { type: "auto" } },
      defaultPoint: {
        marker: {
          outline: {
            width: 2,
            color: "currentColor",
          },
          fill: "white",
        },
      },
      //   series: [
      //     {
      //       name: "FoodLog",
      //       points: this.getFoodPoints(),
      //     },
      //   ],
    };
    return {
      options,
      foodLog: [],
    };
  },

  created() {
    for (let i = 0; i < 4; i++) {
      this.foodLog.push({
        type: "",
        calories: 300 + Math.random() * 100,
        carbs: null,
        protein: null,
        fats: null,
        fiber: null,
        servingSize: null,
        quickAdd: null,
        date: "02/04/2023",
      });
    }
    for (let i = 0; i < 4; i++) {
      this.foodLog.push({
        type: "",
        calories: 300 + Math.random() * 100,
        carbs: null,
        protein: null,
        fats: null,
        fiber: null,
        servingSize: null,
        quickAdd: null,
        date: "02/03/2023",
      });
    }
    for (let i = 0; i < 4; i++) {
      this.foodLog.push({
        type: "",
        calories: 300 + Math.random() * 100,
        carbs: null,
        protein: null,
        fats: null,
        fiber: null,
        servingSize: null,
        quickAdd: null,
        date: "02/02/2023",
      });
    }
    for (let i = 0; i < 4; i++) {
      this.foodLog.push({
        type: "",
        calories: 300 + Math.random() * 100,
        carbs: null,
        protein: null,
        fats: null,
        fiber: null,
        servingSize: null,
        quickAdd: null,
        date: "02/01/2023",
      });
    }
    for (let i = 0; i < 4; i++) {
      this.foodLog.push({
        type: "",
        calories: 300 + Math.random() * 100,
        carbs: null,
        protein: null,
        fats: null,
        fiber: null,
        servingSize: null,
        quickAdd: null,
        date: "01/31/2023",
      });
    }
    for (let i = 0; i < 4; i++) {
      this.foodLog.push({
        type: "",
        calories: 300 + Math.random() * 100,
        carbs: null,
        protein: null,
        fats: null,
        fiber: null,
        servingSize: null,
        quickAdd: null,
        date: "01/30/2023",
      });
    }
    for (let i = 0; i < 4; i++) {
      this.foodLog.push({
        type: "",
        calories: 300 + Math.random() * 100,
        carbs: null,
        protein: null,
        fats: null,
        fiber: null,
        servingSize: null,
        quickAdd: null,
        date: "01/29/2023",
      });
    }

    this.options.series = [
      {
        name: "FoodLog",
        points: this.getFoodPoints(),
      },
    ];
    console.log("FoodLog:", this.foodLog);
    //   FoodService.getAllFoods().then((response) => {
    //   this.foodLog = response.data;
    // });
  },

  methods: {
    updateData() {
      this.options = {
        series: [
          {
            name: "Purchases",
            points: this.getFoodPoints(),
          },
        ],
      };
    },

    getFoodPoints() {
      let points = [];
      let now = new Date();
      for (let i = 0; i < 7; i++) {
        let eachDay = new Date(now.getTime() - i * 24 * 60 * 60 * 1000);
        

        let totalCalories = this.foodLog
          .filter((food) => {
            let foodDate = new Date(food.date);
            let sameDay = foodDate.getDate() == eachDay.getDate();
            let sameMonth = foodDate.getMonth() == eachDay.getMonth();
            let sameYear = foodDate.getFullYear() == eachDay.getFullYear();

            return sameMonth && sameDay && sameYear;
          })
          .reduce((calories, food) => {
            return calories + food.calories;
          }, 0);

        let foodPoint = {
          id: "p" + (i + 1),
          x: eachDay,
          y: totalCalories,
        };
        points.push(foodPoint);
      }

      return points;
    },
  },
  computed: {},

  components: {
    JSCharting,
  },
};
</script>
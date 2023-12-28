<template>
  <div class="home">
    <div class="album py-5 bg-body-tertiary">
      <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div class="col" v-for="(item, idx) in state.items" :key="idx">

            <!-- Card 컴포넌트 화 -->
            <Card :item="item"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { reactive, onMounted } from "vue";
import Card from "@/components/Card.vue";

export default {
  name: 'Home',
  components: { Card },
  setup() {
    const state = reactive({
      items: []
    });

    onMounted(async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/items"); // URL을 정확하게 지정해주세요
        state.items = response.data;
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    });

    return { state };
  }
};
</script>

<style scoped>
</style>

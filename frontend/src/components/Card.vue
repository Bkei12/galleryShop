<template>
  <div class="col">
    <div class="card shadow-sm">
      <img :src="item.imgPath"/>
      <div class="card-body">
        <p class="card-text">
          <span>{{ item.name }} &nbsp;</span>
          <span class="discount badge bg-danger">
            {{ item.discountPer }}%
          </span>
        </p>
        <div class="d-flex justify-content-between align-items-center">
          <button class="btn btn-primary"  @click="addToCart(item.id)">구입하기</button>
          <small class="price text-muted">{{lib.getNumberFormatted( item.price ) }}원</small>
          <small class="real text-danger">할인 가격: {{ lib.getNumberFormatted(item.price - (item.price * item.discountPer / 100)) }}원</small>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import lib from "@/scripts/lib.js";
import axios from "axios";
export default {
  name : 'Card',
  props :{
    item : Object
  },

  setup() {
    const addToCart = (itemId) => {
      axios.post(`http://localhost:8080/api/cart/items/${itemId}`).then(() => {
        console.log('success')
      })
    };

    return {lib, addToCart}
  }
}

</script>

<style scoped>

.card .card-body .price {
  text-decoration: line-through;
}

</style>
<template>
  <div class="cart">
    <div class="container">
      <ul>
        <li v-for="(item, idx) in items" :key="idx">
          <img :src="item.imgPath"/>
          <span class="name">{{ item.name }}</span>
          <span class="price">{{ lib.getNumberFormatted(item.price) }}원</span>
          
          <i class="delete-text" @click="remove(item.id)">삭제</i>
        </li>
      </ul>
      <router-link to="/order" class="btn btn-primary">구입하기</router-link>
    </div>
  </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
import lib from "@/scripts/lib";

export default {

  data() {
    return {
      items: [
        { id: 1, imgPath: '/public/img/watercolour.jpg', name: 'watercolour', price:  21000000, depth: 30 },
        { id: 2, imgPath: '/public/img/바다.jpg', name: '바다', price: 18000000, depth: 25 },
        { id: 3, imgPath: '/public/img/풍경.jpg', name: '풍경', price: 9500000, depth: 25 },
        { id: 4, imgPath: '/public/img/겨울 숲.jpg', name: '겨울 숲', price: 500000, depth: 25 },
        { id: 5, imgPath: '/public/img/새해의 날.jpg', name: '새해의 날', price: 1000000, depth: 25 },
        { id: 6, imgPath: '/public/img/샴페인.jpg', name: '샴페인', price: 2000000, depth: 25 },
        { id: 7, imgPath: '/public/img/픽업트럭.jpg', name: '픽업트럭', price: 3000000, depth: 25 },
        { id: 8, imgPath: '/public/img/ai 강아지 생성.jpg', name: 'ai 강아지 생성', price: 2500000, depth: 25 },
        { id: 9, imgPath: '/public/img/ai 야구공 생성.jpg', name: 'ai 야구공 생성', price: 1800000, depth: 25 },
        { id: 10, imgPath: '/public/img/cheers.jpg', name: 'cheers', price: 900000, depth: 25 },
        // ... 나머지 이미지 데이터
      ]
    };
  },

  setup() {
    const state = reactive({
      items: []
    })

    const load = () => {
      axios.get("/api/cart/items").then(({data}) => {
        console.log(data);
        state.items = data;
      })
    };

    const remove = (itemId) => {
      axios.delete(`/api/cart/items/${itemId}`).then(() => {
        load();
      })
    }

    load();

    return {state, lib, remove}
  }
}
</script>

<style scoped>
.cart ul {
  list-style: none;
  margin: 0;
  padding: 0;
}

.cart ul li {
  border: 1px solid #eee;
  margin-top: 25px;
  margin-bottom: 25px;
}

.cart ul li img {
  width: 150px;
  height: 150px;
}

.cart ul li .name {
  margin-left: 25px;
}

.cart ul li .price {
  margin-left: 25px;
}

.cart ul li i {
  float: right;
  font-size: 20px;
  margin-top: 65px;
  margin-right: 50px;
}

.cart .btn {
  width:300px;
  display:block;
  margin:0 auto;
  padding:30px 50px;
  font-size: 20px;
}
</style>
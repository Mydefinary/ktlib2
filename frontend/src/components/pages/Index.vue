<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "작가",
          link: "/authors",
      },
      {
          text: "집필",
          link: "/manuscripts",
      },
      {
          text: "원고 목록",
          link: "/manuscriptLists",
      },
      {
          text: "출간",
          link: "/publishes",
      },
      {
          text: "서재(책)",
          link: "/books",
      },
      {
          text: "책 목록",
          link: "/bookLists",
      },
      {
          text: "포인트",
          link: "/points",
      },
      {
          text: "포인트목록",
          link: "/pointsLists",
      },
      {
          text: "사용자",
          link: "/users",
      },
      {
          text: "구독",
          link: "/subscribes",
      },
      {
          text: "구독목록",
          link: "/subscribeLists",
      },
      {
          text: "정기구독",
          link: "/periodSubscribes",
      },
    ],
  }),
};
</script>

<template>
    <div>
        <Number
            label="SubscriptionId"
            v-model="value.subscriptionId"
            :editMode="editMode"
        />
        <Number
            label="bookID"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <Number
            label="userID"
            v-model="value.userId"
            :editMode="editMode"
        />
        <Date
            label="SubscribedAt"
            v-model="value.subscribedAt"
            :editMode="editMode"
        />
        <Date
            label="ExpriedAt"
            v-model="value.expriedAt"
            :editMode="editMode"
        />
        <Date
            label="PaymentAt"
            v-model="value.paymentAt"
            :editMode="editMode"
        />
        <Boolean
            label="PaymentSuccess"
            v-model="value.paymentSuccess"
            :editMode="editMode"
        />
        <Number
            label="ReadCost"
            v-model="value.readCost"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Subscribe',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "subscribes",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

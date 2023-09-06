# SaleCampaignManagementSystem
# Assignment

#Tools and technologies used: SpringBoot with Java version 17, Maven, H2 as database
#Used Spring initializr for creating project.
#Dependencies used
1. Spring Web
2. Spring Data JPA
3. H2 Driver
4. Lombok
# APIs


# Below are the curl as asked - all APIs:

1. Paginated Product API :

curl --location 'localhost:8080/products/getAllPaginationProducts?page=1&pageSize=10'

Response : {
    "productList": [
        {
            "id": "89304749-0f74-4cb6-a81b-5579161d275a",
            "mrp": 0.0,
            "currentPrice": 0.0,
            "discount": 0.0,
            "inventory": 0,
            "finalPrice": 0.0
        },
        {
            "id": "0369c9ac-ecbf-4f23-b2dc-052ec2f6a0c3",
            "mrp": 0.0,
            "currentPrice": 0.0,
            "discount": 0.0,
            "inventory": 0,
            "finalPrice": 0.0
        },
        {
            "id": "a3ca5aa8-d117-4e3c-9c42-92627b3e73f9",
            "mrp": 0.0,
            "currentPrice": 0.0,
            "discount": 0.0,
            "inventory": 0,
            "finalPrice": 0.0
        },
        {
            "id": "d6555e5f-6641-43b9-b7f5-756089f58f8e",
            "mrp": 0.0,
            "currentPrice": 0.0,
            "discount": 0.0,
            "inventory": 0,
            "finalPrice": 0.0
        },
        {
            "id": "259c4273-1d51-4bd2-b277-3695635af329",
            "mrp": 0.0,
            "currentPrice": 0.0,
            "discount": 0.0,
            "inventory": 0,
            "finalPrice": 0.0
        },
        {
            "id": "0fd4fd4f-19e0-4661-b5a7-d2c220c4baf8",
            "mrp": 0.0,
            "currentPrice": 0.0,
            "discount": 0.0,
            "inventory": 0,
            "finalPrice": 0.0
        },
        {
            "id": "986fb55c-314e-43d0-907f-3b712c6dcbb3",
            "mrp": 0.0,
            "currentPrice": 0.0,
            "discount": 0.0,
            "inventory": 0,
            "finalPrice": 0.0
        },
        {
            "id": "0e5a2ac2-0948-4f4d-ac1a-b42de6e6e735",
            "mrp": 0.0,
            "currentPrice": 0.0,
            "discount": 0.0,
            "inventory": 0,
            "finalPrice": 0.0
        },
        {
            "id": "460664ad-7295-4b97-9bb3-a3fd4abbe2e5",
            "mrp": 300.0,
            "currentPrice": 208.35,
            "discount": 16.66,
            "inventory": 2,
            "finalPrice": 250.0
        },
        {
            "id": "bcdf6ce4-2fae-4121-862f-95af89f27179",
            "mrp": 300.0,
            "currentPrice": 208.35,
            "discount": 16.66,
            "inventory": 2,
            "finalPrice": 250.0
        }
    ],
    "page": 1,
    "pageSize": 10,
    "totalPages": 2000
}


2. Create Sale Campaign API : 

curl --location 'localhost:8080/campaigns/createCampaign' 

--header 'Content-Type: application/json' \
--data '{
   "startDate": "2023-12-09",
   "endDate": "2023-09-17",
   "title": "Diwali Discount",
   "campaignDiscount": [
      {
         "productId": "259c4273-1d51-4bd2-b277-3695635af329",
         "discount": "10"
     },
      {
         "productId": "89304749-0f74-4cb6-a81b-5579161d275a",
         "discount": "10"
      }
   ]
}

'

Response : {
    "id": "60946ae9-e5e7-4ad2-b89f-23d16ffb318f",
    "startDate": "2023-12-09",
    "endDate": "2023-09-17",
    "title": "Diwali Discount",
    "pid": "b9fb3b53-6824-4e82-92ad-6a60df6f5185"
}

3. Get All Campaign : 

curl --location 'localhost:8080/campaigns/getAll'

Response : [
    {
        "id": "268d6217-bed6-491b-877e-7dde42323cad",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "89304749-0f74-4cb6-a81b-5579161d275a"
    },
    {
        "id": "c14cc216-ef89-4011-a4b0-0639187f63af",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "0369c9ac-ecbf-4f23-b2dc-052ec2f6a0c3"
    },
    {
        "id": "04b87567-2aea-4871-905f-eda692c55c5a",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "a3ca5aa8-d117-4e3c-9c42-92627b3e73f9"
    },
    {
        "id": "6bb91d99-9d00-4c8c-b7df-d139d002ed15",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "d6555e5f-6641-43b9-b7f5-756089f58f8e"
    },
    {
        "id": "63c73d10-1a50-41bc-a6ec-e6909edcbcc6",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "259c4273-1d51-4bd2-b277-3695635af329"
    },
    {
        "id": "72485f9e-0526-4589-8bca-310d779e9fa6",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "0fd4fd4f-19e0-4661-b5a7-d2c220c4baf8"
    },
    {
        "id": "4ef6965f-aa34-4c6e-9681-a6b083a73e5c",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "986fb55c-314e-43d0-907f-3b712c6dcbb3"
    },
    {
        "id": "ce9efb30-fe6f-413a-8607-b636a25a981f",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "0e5a2ac2-0948-4f4d-ac1a-b42de6e6e735"
    },
    {
        "id": "9bf015d8-e6fc-491c-84e9-5d5a8028e8c5",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "460664ad-7295-4b97-9bb3-a3fd4abbe2e5"
    },
    {
        "id": "796e89c5-c3d3-4417-8548-74947784ccef",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "bcdf6ce4-2fae-4121-862f-95af89f27179"
    },
    {
        "id": "5c1143c7-8f1f-4a62-b551-c37c0dd41632",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "2a32a0dc-3373-47d9-b649-b37e97f61a16"
    },
    {
        "id": "550d4983-4609-4c70-9ac6-0d15f650dadb",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "60600ade-2be4-438a-9ce0-56f1752143f2"
    },
    {
        "id": "431f1413-fce4-48a6-903f-5168118593ba",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "6cd41dfb-171e-48a2-92f5-f9ce24f510ee"
    },
    {
        "id": "84cedaee-cb7f-4560-a27f-491065437a6b",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "b9fb3b53-6824-4e82-92ad-6a60df6f5185"
    },
    {
        "id": "e3d43895-cf51-40e7-8865-67e32ec9b15a",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "89304749-0f74-4cb6-a81b-5579161d275a"
    },
    {
        "id": "d4cec169-93be-46bf-9a63-7506de2dd31e",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "0369c9ac-ecbf-4f23-b2dc-052ec2f6a0c3"
    },
    {
        "id": "edfc73de-55aa-407c-bac6-0531dfb5296b",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "a3ca5aa8-d117-4e3c-9c42-92627b3e73f9"
    },
    {
        "id": "b96c417c-b9c8-4046-aa0f-2d78aadf53ed",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "d6555e5f-6641-43b9-b7f5-756089f58f8e"
    },
    {
        "id": "714250c4-8f46-4460-acba-f88b18ae03dc",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "259c4273-1d51-4bd2-b277-3695635af329"
    },
    {
        "id": "67193168-d410-4e34-99cb-1752f87fe0e8",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "0fd4fd4f-19e0-4661-b5a7-d2c220c4baf8"
    },
    {
        "id": "910762ab-72b5-44fc-a7c6-d8f70af32872",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "986fb55c-314e-43d0-907f-3b712c6dcbb3"
    },
    {
        "id": "96b0cdea-83b2-4fa9-b60e-d31648af7ccf",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "0e5a2ac2-0948-4f4d-ac1a-b42de6e6e735"
    },
    {
        "id": "64159e26-49a7-4026-a34b-a20d0e108bc7",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "460664ad-7295-4b97-9bb3-a3fd4abbe2e5"
    },
    {
        "id": "4a76f7e7-42b3-4bfd-a27b-ef56a88425da",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "bcdf6ce4-2fae-4121-862f-95af89f27179"
    },
    {
        "id": "6f053768-bc29-44da-a66a-7b915d31cac2",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "2a32a0dc-3373-47d9-b649-b37e97f61a16"
    },
    {
        "id": "bdf8f70c-f995-430c-8cd6-928310f852bc",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "60600ade-2be4-438a-9ce0-56f1752143f2"
    },
    {
        "id": "30f01515-bb97-40a3-86b6-af9ba760c45d",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "6cd41dfb-171e-48a2-92f5-f9ce24f510ee"
    },
    {
        "id": "60946ae9-e5e7-4ad2-b89f-23d16ffb318f",
        "startDate": "2023-12-09",
        "endDate": "2023-09-17",
        "title": "Diwali Discount",
        "pid": "b9fb3b53-6824-4e82-92ad-6a60df6f5185"
    }
]

Get All Price History : 

curl --location 'localhost:8080/products/getAllPriceHistory'

Response : [
    {
        "id": "c69a80f6-ba2e-40f7-acde-4adee12c1686",
        "productId": "89304749-0f74-4cb6-a81b-5579161d275a",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "50576096-7b11-4328-a4c0-16fd102e2af5",
        "productId": "0369c9ac-ecbf-4f23-b2dc-052ec2f6a0c3",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "4915a612-477a-4b25-8924-2ec7a90e18f0",
        "productId": "a3ca5aa8-d117-4e3c-9c42-92627b3e73f9",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "73bd9bb0-4530-4699-873b-1a0a71c983ba",
        "productId": "d6555e5f-6641-43b9-b7f5-756089f58f8e",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "d09c824d-2914-4bcf-835a-ae15ed52eac2",
        "productId": "259c4273-1d51-4bd2-b277-3695635af329",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "1523c1a1-82c9-4f28-b4a8-704f31de7310",
        "productId": "0fd4fd4f-19e0-4661-b5a7-d2c220c4baf8",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "046b9c46-6c4f-4e69-a35f-c18577026281",
        "productId": "986fb55c-314e-43d0-907f-3b712c6dcbb3",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "a9776326-310a-4bea-875c-19ef4b08aa98",
        "productId": "0e5a2ac2-0948-4f4d-ac1a-b42de6e6e735",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "1a56ab5f-6c24-4f4a-b402-131d87df063a",
        "productId": "460664ad-7295-4b97-9bb3-a3fd4abbe2e5",
        "oldPrice": 250.0,
        "newPrice": 208.35,
        "changeTime": null
    },
    {
        "id": "37b3e316-407e-49fa-ba9b-c59195d6ccd8",
        "productId": "bcdf6ce4-2fae-4121-862f-95af89f27179",
        "oldPrice": 250.0,
        "newPrice": 208.35,
        "changeTime": null
    },
    {
        "id": "5e2322bf-89a3-44a9-aaff-2209c7a4235c",
        "productId": "2a32a0dc-3373-47d9-b649-b37e97f61a16",
        "oldPrice": 250.0,
        "newPrice": 208.35,
        "changeTime": null
    },
    {
        "id": "491d7a5e-b9f3-4e06-adcb-7d7f636ee270",
        "productId": "60600ade-2be4-438a-9ce0-56f1752143f2",
        "oldPrice": 250.0,
        "newPrice": 208.35,
        "changeTime": null
    },
    {
        "id": "47dd0c04-f622-4bb4-8706-7e8105dcd52e",
        "productId": "6cd41dfb-171e-48a2-92f5-f9ce24f510ee",
        "oldPrice": 250.0,
        "newPrice": 208.35,
        "changeTime": null
    },
    {
        "id": "45559235-8e54-43af-a097-140c69012541",
        "productId": "b9fb3b53-6824-4e82-92ad-6a60df6f5185",
        "oldPrice": 250.0,
        "newPrice": 208.35,
        "changeTime": null
    },
    {
        "id": "b049b7bb-5f39-45d6-ba95-e34f5257e6b4",
        "productId": "89304749-0f74-4cb6-a81b-5579161d275a",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "a7030e60-6d74-4e97-97d2-e9758760437b",
        "productId": "0369c9ac-ecbf-4f23-b2dc-052ec2f6a0c3",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "f7013f06-ce57-4da4-876c-6eac99c451b2",
        "productId": "a3ca5aa8-d117-4e3c-9c42-92627b3e73f9",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "1db89138-5c84-473c-b7d2-b878ca4560a6",
        "productId": "d6555e5f-6641-43b9-b7f5-756089f58f8e",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "0cdf0310-6ffa-497e-b85e-e263cab7fac6",
        "productId": "259c4273-1d51-4bd2-b277-3695635af329",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "8333536d-cbe3-4e43-b599-c306e7da2060",
        "productId": "0fd4fd4f-19e0-4661-b5a7-d2c220c4baf8",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "6be9bed4-9d6a-4b0c-8d57-006580c8eb75",
        "productId": "986fb55c-314e-43d0-907f-3b712c6dcbb3",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "224beebb-38f5-427b-9c14-73bc0043c925",
        "productId": "0e5a2ac2-0948-4f4d-ac1a-b42de6e6e735",
        "oldPrice": 0.0,
        "newPrice": 0.0,
        "changeTime": null
    },
    {
        "id": "446da9c3-3ff7-4aae-a8e7-3ae396033cae",
        "productId": "460664ad-7295-4b97-9bb3-a3fd4abbe2e5",
        "oldPrice": 208.35,
        "newPrice": 173.63889,
        "changeTime": null
    },
    {
        "id": "e93bde87-8b46-4751-82a6-48be134f419e",
        "productId": "bcdf6ce4-2fae-4121-862f-95af89f27179",
        "oldPrice": 208.35,
        "newPrice": 173.63889,
        "changeTime": null
    },
    {
        "id": "7f5382ba-c26b-45f4-8690-4e5e6565f665",
        "productId": "2a32a0dc-3373-47d9-b649-b37e97f61a16",
        "oldPrice": 208.35,
        "newPrice": 173.63889,
        "changeTime": null
    },
    {
        "id": "25d9099e-49fe-4356-9b98-a56041133bad",
        "productId": "60600ade-2be4-438a-9ce0-56f1752143f2",
        "oldPrice": 208.35,
        "newPrice": 173.63889,
        "changeTime": null
    },
    {
        "id": "34826190-3b60-4dca-891a-99ab48bcebcb",
        "productId": "6cd41dfb-171e-48a2-92f5-f9ce24f510ee",
        "oldPrice": 208.35,
        "newPrice": 173.63889,
        "changeTime": null
    },
    {
        "id": "44b63bed-0cc4-4ec4-83c8-2771ab4427b4",
        "productId": "b9fb3b53-6824-4e82-92ad-6a60df6f5185",
        "oldPrice": 208.35,
        "newPrice": 173.63889,
        "changeTime": null
    }
]

# Other Apis are also in the Repository

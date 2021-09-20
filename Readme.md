#Meetings API

`mutation createPerson {  createPerson(person:{
firstName: "Organizer",
lastName: "Admin",
email: "ghi@jkl.com",
phoneNumber: "+91919191919191"
}){
id
}}`

`mutation createPerson {  createPerson(person:{
firstName: "Invitee",
lastName: "User",
email: "abc@def.com",
phoneNumber: "+91919191919192"
}){
id
}}`

`mutation createMeeting {
createMeeting(meeting: {startsAt: 1632123084000, endsAt: 1632126684000,
organizerID: "10f50488-33c2-482c-9520-24a1ae36c5fe",
invitees: ["7c987c03-4e5f-4e11-84c3-f9663e8cfaab"],
agendas:[{title:"Title1",description:"Desc1"}]
}) {
id
}
}
`

"82336033-4529-41e5-ad7d-7b9f33d5da4e"

`query getMeetings {
getMeetings{
id,
startsAt,
endsAt,
organizer{
id,
firstName,
lastName,
email,
phoneNumber
},
invitees{
id,
firstName,
lastName,
email,
phoneNumber
}
agendas {
id
title
description
}
}
}`


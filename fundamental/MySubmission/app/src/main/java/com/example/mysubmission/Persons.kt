package com.example.mysubmission

object Persons {
    private val usernames = arrayOf(
        "JakeWharton",
        "amitshekhariitbhu",
        "romainguy",
        "chrisbanes",
        "tipsy",
        "ravi8x",
        "jasoet",
        "budioktaviyan",
        "hendisantika",
        "sidiqpermana"
    )

    private val name = arrayOf(
        "Jake Wharton",
        "Amit Shekhar",
        "Romain Guy",
        "Chris Banes",
        "David",
        "Ravi Tamada",
        "Deny Prasetyo",
        "Budi Oktaviyan",
        "Hendi Santika",
        "Sidiq Permana"
    )

    private val location = arrayOf(
        "Pittsburgh, PA, USA",
        "New Delhi, India",
        "California",
        "Sydney, Australia",
        "Trondheim, Norway",
        "India",
        "Kotagede, Yogyakarta, Indonesia",
        "Jakarta, Indonesia",
        "Bojongsoang - Bandung Jawa Barat",
        "Jakarta Indonesia"
    )

    private val repository = arrayOf(102,37,9,30,56,28,44,110,1064,65)

    private val company = arrayOf(
        "Google, Inc.",
        "MindOrksOpenSource",
        "Google",
        "Google working on @android",
        "Working Group Two",
        "AndroidHive | Droid5",
        "gojek-engineering",
        "KotlinID",
        "JVMDeveloperID @KotlinID @IDDevOps",
        "Nusantara Beta Studio"
    )

    private val followers = arrayOf(56995,5153,7972,14725,788,18628,277,178,428,465)
    private val following = arrayOf(12,2,0,1,0,3,39,23,61,10)

    private val avatar = arrayOf(
        R.drawable.user1,
        R.drawable.user2,
        R.drawable.user3,
        R.drawable.user4,
        R.drawable.user5,
        R.drawable.user6,
        R.drawable.user7,
        R.drawable.user8,
        R.drawable.user9,
        R.drawable.user10
    )

    val datalist:ArrayList<PersonModel>
    get() {
        val list = arrayListOf<PersonModel>()
        for (position in usernames.indices){
            val person = PersonModel()
            person.username = usernames[position]
            person.name = name[position]
            person.company = company[position]
            person.following = following[position]
            person.followers = followers[position]
            person.location = location[position]
            person.repository = repository[position]
            person.image = avatar[position]
            list.add(person)
        }
        return list
    }

}








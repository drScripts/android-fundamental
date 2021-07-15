package com.example.myunittesting

class MainViewModel(private val cuboidModel: CuboidModel) {

    fun getCircumFarce() : Double = cuboidModel.getCircumface()
    fun getSurfaceArea() : Double = cuboidModel.getSurfaceArea()
    fun getVolume() : Double = cuboidModel.getVolume()
    fun save(l:Double,w:Double,h:Double){
        cuboidModel.save(l,w,h)
    }

}
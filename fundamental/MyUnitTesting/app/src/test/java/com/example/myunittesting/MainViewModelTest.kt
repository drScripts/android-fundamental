package com.example.myunittesting

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.mock

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before(){
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun getCircumFarce() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength,dummyWidth,dummyHeight)
        val circum = mainViewModel.getCircumFarce()
        assertEquals(circum,dummyCircumference,0.00001)
    }

    @Test
    fun getSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength,dummyWidth,dummyHeight)
        val surface = mainViewModel.getSurfaceArea()
        assertEquals(surface,dummySurfaceArea,0.0001)
    }

    @Test
    fun getVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength,dummyWidth,dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume,volume,0.0001)
    }

    @Test
    fun save() {
    }
}
package com.example.learncompose.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.learncompose.model.NotesModel

class NotesViewModel: ViewModel() {

    val _notes = mutableStateListOf<NotesModel>()
    val notes: List<NotesModel> = _notes
    var id:Int = 0
    var curr_title= mutableStateOf("")
    var curr_desc=mutableStateOf("")

     fun getNotesById(id:Int):NotesModel?{
       var foundObj:NotesModel?=null;
        _notes.forEach{it->
            if(it.id==id) foundObj=it;
        }
        return foundObj
    }

    fun insertNotes( ):Boolean{
        val objToInsert= NotesModel(this.id, this.curr_title.value, this.curr_desc.value);

        resetFields()
        return _notes.add(objToInsert);
    }

    fun deleteNotes():Boolean{
        var objToDelete:NotesModel?=null;
        _notes.forEach{it->
            if(it.id==this.id) objToDelete=it;
        }
        objToDelete?.let {
            _notes.remove(it)
            resetFields()
            return true
        }

        resetFields()
        return false
    }

    private fun resetFields() {
        id=_notes.size;
        curr_title.value=""
        curr_desc.value=""
    }

    fun updateNotes():Boolean{
        var objectToInsert= NotesModel(id,this.curr_title.value, this.curr_desc.value);
        var indexToDelete:Int?=null

        _notes.forEachIndexed{index,it->
            if(it.id==this.id){
                indexToDelete=index
            }
        }
        indexToDelete?.let{
            _notes.set(it,objectToInsert);
            resetFields()
            return true;
        }
        resetFields()
        return false;
    }
}
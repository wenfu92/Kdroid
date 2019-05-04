package com.vipkid.find.viewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.howshea.basemodule.component.lifecycle.RxViewModel
import com.vipkid.base.extentions.dispatchDefault
import com.vipkid.find.model.History
import com.vipkid.find.model.HistoryResult
import com.vipkid.find.net.FindApiService
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import java.lang.Exception

/**
 * Created by WWF
 * on 2019/5/3
 */
class FindViewModel : RxViewModel() {
    private val history: MutableLiveData<List<HistoryResult>> = MutableLiveData()
    private val rxError:MutableLiveData<Throwable> = MutableLiveData()
    fun getHistory() :LiveData<List<HistoryResult>> =history
    fun refrosh(){
        FindApiService.getHistory(1,1).disDispose()
    }
    private fun Observable<History>.disDispose(){
        this.dispatchDefault()
                .subscribeBy (
                        onNext = {
                            if(it.error||it.results.isEmpty()){
                                rxError.value=Exception("服务器异常")
                            }else{
                                history.value=it.results
                            }
                        },
                        onError = {
                            rxError.value=it
                        }
                )

    }


}
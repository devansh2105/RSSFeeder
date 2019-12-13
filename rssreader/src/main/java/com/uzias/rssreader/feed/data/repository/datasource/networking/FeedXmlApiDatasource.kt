package com.uzias.rssreader.feed.data.repository.datasource.networking

import com.uzias.rssreader.feed.data.repository.datasource.FeedDatasource
import com.uzias.rssreader.feed.data.repository.datasource.networking.mapper.RssFeedMapper
import com.uzias.rssreader.feed.domain.model.Rss
import io.reactivex.Completable
import io.reactivex.Observable

open class FeedXmlApiDatasource(val feedXmlApi: FeedXmlApi) : FeedDatasource {

    override fun deleteRss(url: String): Completable = Completable.complete()

    override fun getRss(): Observable<Rss> = Observable.empty()

    override fun save(rss: Rss): Observable<Rss> = Observable.empty()

    override fun getRssByUrl(url: String): Observable<Rss> {
        return feedXmlApi.getRss(url).map{it -> RssFeedMapper.transformFrom(it, url)}
    }
}
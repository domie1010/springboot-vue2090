<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>
				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="站内新闻"
				source_table="article"
			  ></list_result_search>
				<!-- 论坛搜索结果 -->
			  <list_result_search
				:list="result_forum"
				title="在线留言"
				source_table="forum"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/registered_user/list', 'get')"
				:list="result_registered_user_user_name"
				title="注册用户用户名"
				source_table="registered_user"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/video_classification/list', 'get')"
				:list="result_video_classification_video_category"
				title="视频分类视频类别"
				source_table="video_classification"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/wonderful_video/list', 'get')"
				:list="result_wonderful_video_video_name"
				title="精彩视频视频名称"
				source_table="wonderful_video"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/wonderful_video/list', 'get')"
				:list="result_wonderful_video_video_category"
				title="精彩视频视频类别"
				source_table="wonderful_video"
			  ></list_result_search>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
	  "result_forum": [],
			"result_registered_user_user_name":[],
			"result_video_classification_video_category":[],
			"result_wonderful_video_video_name":[],
			"result_wonderful_video_video_category":[],
	};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},
	/**
	 * 获取在线留言
	 */
	get_forum() {
	  this.$get("~/api/forum/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_forum = json.result.list;
		}
	  });
	},
	/**
	 * 获取user_name
	 */
	get_registered_user_user_name(){
		this.$get("~/api/registered_user/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_registered_user_user_name = json.result.list;
			result_registered_user_user_name.map(o => o.title = o['user_name'])
	  			this.result_registered_user_user_name = result_registered_user_user_name
		 	}
		});
	},
	/**
	 * 获取video_category
	 */
	get_video_classification_video_category(){
		this.$get("~/api/video_classification/get_list?like=0", { page: 1, size: 10, "video_category": this.query.word }, (json) => {
		  if (json.result) {
			var result_video_classification_video_category = json.result.list;
			result_video_classification_video_category.map(o => o.title = o['video_category'])
	  			this.result_video_classification_video_category = result_video_classification_video_category
		 	}
		});
	},
	/**
	 * 获取video_name
	 */
	get_wonderful_video_video_name(){
		this.$get("~/api/wonderful_video/get_list?like=0", { page: 1, size: 10, "video_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_wonderful_video_video_name = json.result.list;
			result_wonderful_video_video_name.map(o => o.title = o['video_name'])
	  			this.result_wonderful_video_video_name = result_wonderful_video_video_name
		 	}
		});
	},
	/**
	 * 获取video_category
	 */
	get_wonderful_video_video_category(){
		this.$get("~/api/wonderful_video/get_list?like=0", { page: 1, size: 10, "video_category": this.query.word }, (json) => {
		  if (json.result) {
			var result_wonderful_video_video_category = json.result.list;
			result_wonderful_video_video_category.map(o => o.title = o['video_category'])
	  			this.result_wonderful_video_video_category = result_wonderful_video_video_category
		 	}
		});
	},

  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
	this.get_forum();
		this.get_registered_user_user_name();
		this.get_video_classification_video_category();
		this.get_wonderful_video_video_name();
		this.get_wonderful_video_video_category();
  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
	  this.get_forum();
	  this.get_registered_user_user_name();
	  this.get_video_classification_video_category();
	  this.get_wonderful_video_video_name();
	  this.get_wonderful_video_video_category();
	},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>

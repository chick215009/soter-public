import request from '@/utils/request'

export function listCommit(query) {
  return request({
    url: 'github/commit/list',
    method: 'get',
    params: query
  })
}

# time.thrift
namespace java tserver.gen
typedef i64 Timestamp
service TmServer {
   Timestamp time()
}

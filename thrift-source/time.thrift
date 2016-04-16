# time.thrift
namespace java tserver.gen
#namespace cpp tserver.gen
typedef i64 Timestamp
service TmServer {
   Timestamp time()
}

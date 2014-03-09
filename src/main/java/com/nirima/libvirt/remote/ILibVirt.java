package com.nirima.libvirt.remote;

import com.nirima.libvirt.model.*;
import com.nirima.libvirt.xdr.XDRInterface;
import com.nirima.libvirt.xdr.XDRMethod;

import javax.annotation.Nonnull;
import java.util.UUID;

/**
 * @author Nigel Magnay
 */
@XDRInterface(program = 0x20008086)
public interface ILibVirt {
    @XDRMethod(proc = 1)
    void connectOpen(String name, int flags);

    @XDRMethod(proc = 2)
    void connectClose();

    @XDRMethod(proc = 3)
    @Nonnull
    String connectGetType();

    @XDRMethod(proc = 4)
    long connectGetVersion();

    @XDRMethod(proc = 5)
    int connectGetMaxVcpus(String type);

    @XDRMethod(proc = 6)
    RemoteNodeInfo nodeGetInfo();

    @XDRMethod(proc = 7)
    @Nonnull
    String connectGetCapabilities();

    @XDRMethod(proc = 8)
    void domainAttachDevice(@Nonnull RemoteDomain dom, @Nonnull String xml);

    @XDRMethod(proc = 9)
    void domainCreate(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 10)
    @Nonnull
    RemoteDomain domainCreateXml(@Nonnull String xml_desc, int flags);

    @XDRMethod(proc = 11)
    @Nonnull
    RemoteDomain domainDefineXml(@Nonnull String xml);

    @XDRMethod(proc = 12)
    void domainDestroy(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 13)
    void domainDetachDevice(@Nonnull RemoteDomain dom, @Nonnull String xml);

    @XDRMethod(proc = 14)
    @Nonnull
    String domainGetXmlDesc(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 15)
    int domainGetAutostart(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 16)
    RemoteDomainInfo domainGetInfo(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 17)
    long domainGetMaxMemory(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 18)
    int domainGetMaxVcpus(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 19)
    @Nonnull
    String domainGetOsType(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 20)
    RemoteDomainVcpus domainGetVcpus(@Nonnull RemoteDomain dom, int maxinfo, int maplen);

    @XDRMethod(proc = 21)
    @Nonnull
    String[] connectListDefinedDomains(int maxnames);

    @XDRMethod(proc = 22)
    @Nonnull
    RemoteDomain domainLookupById(int id);

    @XDRMethod(proc = 23)
    @Nonnull
    RemoteDomain domainLookupByName(@Nonnull String name);

    @XDRMethod(proc = 24)
    @Nonnull
    RemoteDomain domainLookupByUuid(UUID uuid);

    @XDRMethod(proc = 25)
    int connectNumOfDefinedDomains();

    @XDRMethod(proc = 26)
    void domainPinVcpu(@Nonnull RemoteDomain dom, int vcpu, int[] cpumap);

    @XDRMethod(proc = 27)
    void domainReboot(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 28)
    void domainResume(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 29)
    void domainSetAutostart(@Nonnull RemoteDomain dom, int autostart);

    @XDRMethod(proc = 30)
    void domainSetMaxMemory(@Nonnull RemoteDomain dom, long memory);

    @XDRMethod(proc = 31)
    void domainSetMemory(@Nonnull RemoteDomain dom, long memory);

    @XDRMethod(proc = 32)
    void domainSetVcpus(@Nonnull RemoteDomain dom, int nvcpus);

    @XDRMethod(proc = 33)
    void domainShutdown(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 34)
    void domainSuspend(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 35)
    void domainUndefine(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 36)
    @Nonnull
    String[] connectListDefinedNetworks(int maxnames);

    @XDRMethod(proc = 37)
    int[] connectListDomains(int maxids);

    @XDRMethod(proc = 38)
    @Nonnull
    String[] connectListNetworks(int maxnames);

    @XDRMethod(proc = 39)
    void networkCreate(@Nonnull RemoteNetwork net);

    @XDRMethod(proc = 40)
    @Nonnull
    RemoteNetwork networkCreateXml(@Nonnull String xml);

    @XDRMethod(proc = 41)
    @Nonnull
    RemoteNetwork networkDefineXml(@Nonnull String xml);

    @XDRMethod(proc = 42)
    void networkDestroy(@Nonnull RemoteNetwork net);

    @XDRMethod(proc = 43)
    @Nonnull
    String networkGetXmlDesc(@Nonnull RemoteNetwork net, int flags);

    @XDRMethod(proc = 44)
    int networkGetAutostart(@Nonnull RemoteNetwork net);

    @XDRMethod(proc = 45)
    @Nonnull
    String networkGetBridgeName(@Nonnull RemoteNetwork net);

    @XDRMethod(proc = 46)
    @Nonnull
    RemoteNetwork networkLookupByName(@Nonnull String name);

    @XDRMethod(proc = 47)
    @Nonnull
    RemoteNetwork networkLookupByUuid(UUID uuid);

    @XDRMethod(proc = 48)
    void networkSetAutostart(@Nonnull RemoteNetwork net, int autostart);

    @XDRMethod(proc = 49)
    void networkUndefine(@Nonnull RemoteNetwork net);

    @XDRMethod(proc = 50)
    int connectNumOfDefinedNetworks();

    @XDRMethod(proc = 51)
    int connectNumOfDomains();

    @XDRMethod(proc = 52)
    int connectNumOfNetworks();

    @XDRMethod(proc = 53)
    void domainCoreDump(@Nonnull RemoteDomain dom, @Nonnull String to, int flags);

    @XDRMethod(proc = 54)
    void domainRestore(@Nonnull String from);

    @XDRMethod(proc = 55)
    void domainSave(@Nonnull RemoteDomain dom, @Nonnull String to);

    @XDRMethod(proc = 56)
    RemoteDomainSchedulerType domainGetSchedulerType(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 57)
    RemoteTypedParam[] domainGetSchedulerParameters(@Nonnull RemoteDomain dom, int nparams);

    @XDRMethod(proc = 58)
    void domainSetSchedulerParameters(@Nonnull RemoteDomain dom, RemoteTypedParam[] params);

    @XDRMethod(proc = 59)
    @Nonnull
    String connectGetHostname();

    @XDRMethod(proc = 60)
    int connectSupportsFeature(int feature);

    @XDRMethod(proc = 61)
    RemoteDomainMigratePrepare domainMigratePrepare(String uri_in, long flags, String dname, long resource);

    @XDRMethod(proc = 62)
    void domainMigratePerform(@Nonnull RemoteDomain dom, int[] cookie, @Nonnull String uri, long flags, String dname, long resource);

    @XDRMethod(proc = 63)
    @Nonnull
    RemoteDomain domainMigrateFinish(@Nonnull String dname, int[] cookie, @Nonnull String uri, long flags);

    @XDRMethod(proc = 64)
    RemoteDomainBlockStats domainBlockStats(@Nonnull RemoteDomain dom, @Nonnull String path);

    @XDRMethod(proc = 65)
    RemoteDomainInterfaceStats domainInterfaceStats(@Nonnull RemoteDomain dom, @Nonnull String path);

    @XDRMethod(proc = 66)
    int[] authList();

    @XDRMethod(proc = 67)
    @Nonnull
    String authSaslInit();

    @XDRMethod(proc = 68)
    RemoteAuthSaslStart authSaslStart(@Nonnull String mech, int nil, char[] data);

    @XDRMethod(proc = 69)
    RemoteAuthSaslStep authSaslStep(int nil, char[] data);

    @XDRMethod(proc = 70)
    int authPolkit();

    @XDRMethod(proc = 71)
    int connectNumOfStoragePools();

    @XDRMethod(proc = 72)
    @Nonnull
    String[] connectListStoragePools(int maxnames);

    @XDRMethod(proc = 73)
    int connectNumOfDefinedStoragePools();

    @XDRMethod(proc = 74)
    @Nonnull
    String[] connectListDefinedStoragePools(int maxnames);

    @XDRMethod(proc = 75)
    @Nonnull
    String connectFindStoragePoolSources(@Nonnull String type, String srcSpec, int flags);

    @XDRMethod(proc = 76)
    @Nonnull
    RemoteStoragePool storagePoolCreateXml(@Nonnull String xml, int flags);

    @XDRMethod(proc = 77)
    @Nonnull
    RemoteStoragePool storagePoolDefineXml(@Nonnull String xml, int flags);

    @XDRMethod(proc = 78)
    void storagePoolCreate(@Nonnull RemoteStoragePool pool, int flags);

    @XDRMethod(proc = 79)
    void storagePoolBuild(@Nonnull RemoteStoragePool pool, int flags);

    @XDRMethod(proc = 80)
    void storagePoolDestroy(@Nonnull RemoteStoragePool pool);

    @XDRMethod(proc = 81)
    void storagePoolDelete(@Nonnull RemoteStoragePool pool, int flags);

    @XDRMethod(proc = 82)
    void storagePoolUndefine(@Nonnull RemoteStoragePool pool);

    @XDRMethod(proc = 83)
    void storagePoolRefresh(@Nonnull RemoteStoragePool pool, int flags);

    @XDRMethod(proc = 84)
    @Nonnull
    RemoteStoragePool storagePoolLookupByName(@Nonnull String name);

    @XDRMethod(proc = 85)
    @Nonnull
    RemoteStoragePool storagePoolLookupByUuid(UUID uuid);

    @XDRMethod(proc = 86)
    @Nonnull
    RemoteStoragePool storagePoolLookupByVolume(@Nonnull RemoteStorageVol vol);

    @XDRMethod(proc = 87)
    RemoteStoragePoolInfo storagePoolGetInfo(@Nonnull RemoteStoragePool pool);

    @XDRMethod(proc = 88)
    @Nonnull
    String storagePoolGetXmlDesc(@Nonnull RemoteStoragePool pool, int flags);

    @XDRMethod(proc = 89)
    int storagePoolGetAutostart(@Nonnull RemoteStoragePool pool);

    @XDRMethod(proc = 90)
    void storagePoolSetAutostart(@Nonnull RemoteStoragePool pool, int autostart);

    @XDRMethod(proc = 91)
    int storagePoolNumOfVolumes(@Nonnull RemoteStoragePool pool);

    @XDRMethod(proc = 92)
    @Nonnull
    String[] storagePoolListVolumes(@Nonnull RemoteStoragePool pool, int maxnames);

    @XDRMethod(proc = 93)
    @Nonnull
    RemoteStorageVol storageVolCreateXml(@Nonnull RemoteStoragePool pool, @Nonnull String xml, int flags);

    @XDRMethod(proc = 94)
    void storageVolDelete(@Nonnull RemoteStorageVol vol, int flags);

    @XDRMethod(proc = 95)
    @Nonnull
    RemoteStorageVol storageVolLookupByName(@Nonnull RemoteStoragePool pool, @Nonnull String name);

    @XDRMethod(proc = 96)
    @Nonnull
    RemoteStorageVol storageVolLookupByKey(@Nonnull String key);

    @XDRMethod(proc = 97)
    @Nonnull
    RemoteStorageVol storageVolLookupByPath(@Nonnull String path);

    @XDRMethod(proc = 98)
    RemoteStorageVolInfo storageVolGetInfo(@Nonnull RemoteStorageVol vol);

    @XDRMethod(proc = 99)
    @Nonnull
    String storageVolGetXmlDesc(@Nonnull RemoteStorageVol vol, int flags);

    @XDRMethod(proc = 100)
    @Nonnull
    String storageVolGetPath(@Nonnull RemoteStorageVol vol);

    @XDRMethod(proc = 101)
    long[] nodeGetCellsFreeMemory(int startCell, int maxcells);

    @XDRMethod(proc = 102)
    long nodeGetFreeMemory();

    @XDRMethod(proc = 103)
    int[] domainBlockPeek(@Nonnull RemoteDomain dom, @Nonnull String path, long offset, int size, int flags);

    @XDRMethod(proc = 104)
    int[] domainMemoryPeek(@Nonnull RemoteDomain dom, long offset, int size, int flags);

    @XDRMethod(proc = 105)
    int connectDomainEventRegister();

    @XDRMethod(proc = 106)
    int connectDomainEventDeregister();

    @XDRMethod(proc = 107)
    void domainEventLifecycle();

    @XDRMethod(proc = 108)
    RemoteDomainMigratePrepare2 domainMigratePrepare2(String uri_in, long flags, String dname, long resource, @Nonnull String dom_xml);

    @XDRMethod(proc = 109)
    @Nonnull
    RemoteDomain domainMigrateFinish2(@Nonnull String dname, int[] cookie, @Nonnull String uri, long flags, int retcode);

    @XDRMethod(proc = 110)
    @Nonnull
    String connectGetUri();

    @XDRMethod(proc = 111)
    int nodeNumOfDevices(String cap, int flags);

    @XDRMethod(proc = 112)
    @Nonnull
    String[] nodeListDevices(String cap, int maxnames, int flags);

    @XDRMethod(proc = 113)
    @Nonnull
    String /*RemoteNodeDevice*/  nodeDeviceLookupByName(@Nonnull String name);

    @XDRMethod(proc = 114)
    @Nonnull
    String nodeDeviceGetXmlDesc(@Nonnull String name, int flags);

    @XDRMethod(proc = 115)
    String nodeDeviceGetParent(@Nonnull String name);

    @XDRMethod(proc = 116)
    int nodeDeviceNumOfCaps(@Nonnull String name);

    @XDRMethod(proc = 117)
    @Nonnull
    String[] nodeDeviceListCaps(@Nonnull String name, int maxnames);

    @XDRMethod(proc = 118)
    void nodeDeviceDettach(@Nonnull String name);

    @XDRMethod(proc = 119)
    void nodeDeviceReAttach(@Nonnull String name);

    @XDRMethod(proc = 120)
    void nodeDeviceReset(@Nonnull String name);

    @XDRMethod(proc = 121)
    RemoteDomainSecurityLabel domainGetSecurityLabel(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 122)
    RemoteNodeSecurityModel nodeGetSecurityModel();

    @XDRMethod(proc = 123)
    @Nonnull
    String /*RemoteNodeDevice*/  nodeDeviceCreateXml(@Nonnull String xml_desc, int flags);

    @XDRMethod(proc = 124)
    void nodeDeviceDestroy(@Nonnull String name);

    @XDRMethod(proc = 125)
    @Nonnull
    RemoteStorageVol storageVolCreateXmlFrom(@Nonnull RemoteStoragePool pool, @Nonnull String xml, @Nonnull RemoteStorageVol clonevol, int flags);

    @XDRMethod(proc = 126)
    int connectNumOfInterfaces();

    @XDRMethod(proc = 127)
    @Nonnull
    String[] connectListInterfaces(int maxnames);

    @XDRMethod(proc = 128)
    @Nonnull
    RemoteInterface interfaceLookupByName(@Nonnull String name);

    @XDRMethod(proc = 129)
    @Nonnull
    RemoteInterface interfaceLookupByMacString(@Nonnull String mac);

    @XDRMethod(proc = 130)
    @Nonnull
    String interfaceGetXmlDesc(@Nonnull RemoteInterface iface, int flags);

    @XDRMethod(proc = 131)
    @Nonnull
    RemoteInterface interfaceDefineXml(@Nonnull String xml, int flags);

    @XDRMethod(proc = 132)
    void interfaceUndefine(@Nonnull RemoteInterface iface);

    @XDRMethod(proc = 133)
    void interfaceCreate(@Nonnull RemoteInterface iface, int flags);

    @XDRMethod(proc = 134)
    void interfaceDestroy(@Nonnull RemoteInterface iface, int flags);

    @XDRMethod(proc = 135)
    @Nonnull
    String connectDomainXmlFromNative(@Nonnull String nativeFormat, @Nonnull String nativeConfig, int flags);

    @XDRMethod(proc = 136)
    @Nonnull
    String connectDomainXmlToNative(@Nonnull String nativeFormat, @Nonnull String domainXml, int flags);

    @XDRMethod(proc = 137)
    int connectNumOfDefinedInterfaces();

    @XDRMethod(proc = 138)
    @Nonnull
    String[] connectListDefinedInterfaces(int maxnames);

    @XDRMethod(proc = 139)
    int connectNumOfSecrets();

    @XDRMethod(proc = 140)
    @Nonnull
    String[] connectListSecrets(int maxuuids);

    @XDRMethod(proc = 141)
    @Nonnull
    RemoteSecret secretLookupByUuid(UUID uuid);

    @XDRMethod(proc = 142)
    @Nonnull
    RemoteSecret secretDefineXml(@Nonnull String xml, int flags);

    @XDRMethod(proc = 143)
    @Nonnull
    String secretGetXmlDesc(@Nonnull RemoteSecret secret, int flags);

    @XDRMethod(proc = 144)
    void secretSetValue(@Nonnull RemoteSecret secret, int[] value, int flags);

    @XDRMethod(proc = 145)
    int[] secretGetValue(@Nonnull RemoteSecret secret, int flags);

    @XDRMethod(proc = 146)
    void secretUndefine(@Nonnull RemoteSecret secret);

    @XDRMethod(proc = 147)
    @Nonnull
    RemoteSecret secretLookupByUsage(int usageType, @Nonnull String usageID);

    @XDRMethod(proc = 148)
    void domainMigratePrepareTunnel(long flags, String dname, long resource, @Nonnull String dom_xml);

    @XDRMethod(proc = 149)
    int connectIsSecure();

    @XDRMethod(proc = 150)
    int domainIsActive(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 151)
    int domainIsPersistent(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 152)
    int networkIsActive(@Nonnull RemoteNetwork net);

    @XDRMethod(proc = 153)
    int networkIsPersistent(@Nonnull RemoteNetwork net);

    @XDRMethod(proc = 154)
    int storagePoolIsActive(@Nonnull RemoteStoragePool pool);

    @XDRMethod(proc = 155)
    int storagePoolIsPersistent(@Nonnull RemoteStoragePool pool);

    @XDRMethod(proc = 156)
    int interfaceIsActive(@Nonnull RemoteInterface iface);

    @XDRMethod(proc = 157)
    long connectGetLibVersion();

    @XDRMethod(proc = 158)
    int connectCompareCpu(@Nonnull String xml, int flags);

    @XDRMethod(proc = 159)
    RemoteDomainMemoryStat[] domainMemoryStats(@Nonnull RemoteDomain dom, int maxStats, int flags);

    @XDRMethod(proc = 160)
    void domainAttachDeviceFlags(@Nonnull RemoteDomain dom, @Nonnull String xml, int flags);

    @XDRMethod(proc = 161)
    void domainDetachDeviceFlags(@Nonnull RemoteDomain dom, @Nonnull String xml, int flags);

    @XDRMethod(proc = 162)
    @Nonnull
    String connectBaselineCpu(@Nonnull String[] xmlCPUs, int flags);

    @XDRMethod(proc = 163)
    RemoteDomainJobInfo domainGetJobInfo(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 164)
    void domainAbortJob(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 165)
    void storageVolWipe(@Nonnull RemoteStorageVol vol, int flags);

    @XDRMethod(proc = 166)
    void domainMigrateSetMaxDowntime(@Nonnull RemoteDomain dom, long downtime, int flags);

    @XDRMethod(proc = 167)
    void connectDomainEventRegisterAny(int eventID);

    @XDRMethod(proc = 168)
    void connectDomainEventDeregisterAny(int eventID);

    @XDRMethod(proc = 169)
    void domainEventReboot();

    @XDRMethod(proc = 170)
    void domainEventRtcChange();

    @XDRMethod(proc = 171)
    void domainEventWatchdog();

    @XDRMethod(proc = 172)
    void domainEventIoError();

    @XDRMethod(proc = 173)
    void domainEventGraphics();

    @XDRMethod(proc = 174)
    void domainUpdateDeviceFlags(@Nonnull RemoteDomain dom, @Nonnull String xml, int flags);

    @XDRMethod(proc = 175)
    @Nonnull
    RemoteNwfilter nwfilterLookupByName(@Nonnull String name);

    @XDRMethod(proc = 176)
    @Nonnull
    RemoteNwfilter nwfilterLookupByUuid(UUID uuid);

    @XDRMethod(proc = 177)
    @Nonnull
    String nwfilterGetXmlDesc(@Nonnull RemoteNwfilter nwfilter, int flags);

    @XDRMethod(proc = 178)
    int connectNumOfNwfilters();

    @XDRMethod(proc = 179)
    @Nonnull
    String[] connectListNwfilters(int maxnames);

    @XDRMethod(proc = 180)
    @Nonnull
    RemoteNwfilter nwfilterDefineXml(@Nonnull String xml);

    @XDRMethod(proc = 181)
    void nwfilterUndefine(@Nonnull RemoteNwfilter nwfilter);

    @XDRMethod(proc = 182)
    void domainManagedSave(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 183)
    int domainHasManagedSaveImage(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 184)
    void domainManagedSaveRemove(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 185)
    @Nonnull
    RemoteDomainSnapshot domainSnapshotCreateXml(@Nonnull RemoteDomain dom, @Nonnull String xml_desc, int flags);

    @XDRMethod(proc = 186)
    @Nonnull
    String domainSnapshotGetXmlDesc(@Nonnull RemoteDomainSnapshot snap, int flags);

    @XDRMethod(proc = 187)
    int domainSnapshotNum(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 188)
    @Nonnull
    String[] domainSnapshotListNames(@Nonnull RemoteDomain dom, int maxnames, int flags);

    @XDRMethod(proc = 189)
    @Nonnull
    RemoteDomainSnapshot domainSnapshotLookupByName(@Nonnull RemoteDomain dom, @Nonnull String name, int flags);

    @XDRMethod(proc = 190)
    int domainHasCurrentSnapshot(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 191)
    @Nonnull
    RemoteDomainSnapshot domainSnapshotCurrent(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 192)
    void domainRevertToSnapshot(@Nonnull RemoteDomainSnapshot snap, int flags);

    @XDRMethod(proc = 193)
    void domainSnapshotDelete(@Nonnull RemoteDomainSnapshot snap, int flags);

    @XDRMethod(proc = 194)
    RemoteDomainBlockInfo domainGetBlockInfo(@Nonnull RemoteDomain dom, @Nonnull String path, int flags);

    @XDRMethod(proc = 195)
    void domainEventIoErrorReason();

    @XDRMethod(proc = 196)
    @Nonnull
    RemoteDomain domainCreateWithFlags(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 197)
    void domainSetMemoryParameters(@Nonnull RemoteDomain dom, RemoteTypedParam[] params, int flags);

    @XDRMethod(proc = 198)
    RemoteDomainMemoryParameters domainGetMemoryParameters(@Nonnull RemoteDomain dom, int nparams, int flags);

    @XDRMethod(proc = 199)
    void domainSetVcpusFlags(@Nonnull RemoteDomain dom, int nvcpus, int flags);

    @XDRMethod(proc = 200)
    int domainGetVcpusFlags(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 201)
    void domainOpenConsole(@Nonnull RemoteDomain dom, String dev_name, int flags);

    @XDRMethod(proc = 202)
    int domainIsUpdated(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 203)
    @Nonnull
    String connectGetSysinfo(int flags);

    @XDRMethod(proc = 204)
    void domainSetMemoryFlags(@Nonnull RemoteDomain dom, long memory, int flags);

    @XDRMethod(proc = 205)
    void domainSetBlkioParameters(@Nonnull RemoteDomain dom, RemoteTypedParam[] params, int flags);

    @XDRMethod(proc = 206)
    RemoteDomainBlkioParameters domainGetBlkioParameters(@Nonnull RemoteDomain dom, int nparams, int flags);

    @XDRMethod(proc = 207)
    void domainMigrateSetMaxSpeed(@Nonnull RemoteDomain dom, long bandwidth, int flags);

    @XDRMethod(proc = 208)
    void storageVolUpload(@Nonnull RemoteStorageVol vol, long offset, long length, int flags);

    @XDRMethod(proc = 209)
    void storageVolDownload(@Nonnull RemoteStorageVol vol, long offset, long length, int flags);

    @XDRMethod(proc = 210)
    void domainInjectNmi(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 211)
    String domainScreenshot(@Nonnull RemoteDomain dom, int screen, int flags);

    @XDRMethod(proc = 212)
    RemoteDomainState domainGetState(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 213)
    RemoteDomainMigrateBegin3 domainMigrateBegin3(@Nonnull RemoteDomain dom, String xmlin, long flags, String dname, long resource);

    @XDRMethod(proc = 214)
    RemoteDomainMigratePrepare3 domainMigratePrepare3(int[] cookie_in, String uri_in, long flags, String dname, long resource, @Nonnull String dom_xml);

    @XDRMethod(proc = 215)
    int[] domainMigratePrepareTunnel3(int[] cookie_in, long flags, String dname, long resource, @Nonnull String dom_xml);

    @XDRMethod(proc = 216)
    int[] domainMigratePerform3(@Nonnull RemoteDomain dom, String xmlin, int[] cookie_in, String dconnuri, String uri, long flags, String dname, long resource);

    @XDRMethod(proc = 217)
    RemoteDomainMigrateFinish3 domainMigrateFinish3(@Nonnull String dname, int[] cookie_in, String dconnuri, String uri, long flags, int cancelled);

    @XDRMethod(proc = 218)
    void domainMigrateConfirm3(@Nonnull RemoteDomain dom, int[] cookie_in, long flags, int cancelled);

    @XDRMethod(proc = 219)
    void domainSetSchedulerParametersFlags(@Nonnull RemoteDomain dom, RemoteTypedParam[] params, int flags);

    @XDRMethod(proc = 220)
    void interfaceChangeBegin(int flags);

    @XDRMethod(proc = 221)
    void interfaceChangeCommit(int flags);

    @XDRMethod(proc = 222)
    void interfaceChangeRollback(int flags);

    @XDRMethod(proc = 223)
    RemoteTypedParam[] domainGetSchedulerParametersFlags(@Nonnull RemoteDomain dom, int nparams, int flags);

    @XDRMethod(proc = 224)
    void domainEventControlError();

    @XDRMethod(proc = 225)
    void domainPinVcpuFlags(@Nonnull RemoteDomain dom, int vcpu, int[] cpumap, int flags);

    @XDRMethod(proc = 226)
    void domainSendKey(@Nonnull RemoteDomain dom, int codeset, int holdtime, int[] keycodes, int flags);

    @XDRMethod(proc = 227)
    RemoteNodeCpuStats nodeGetCpuStats(int cpuNum, int nparams, int flags);

    @XDRMethod(proc = 228)
    RemoteNodeMemoryStats nodeGetMemoryStats(int nparams, int cellNum, int flags);

    @XDRMethod(proc = 229)
    RemoteDomainControlInfo domainGetControlInfo(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 230)
    RemoteDomainVcpuPinInfo domainGetVcpuPinInfo(@Nonnull RemoteDomain dom, int ncpumaps, int maplen, int flags);

    @XDRMethod(proc = 231)
    void domainUndefineFlags(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 232)
    void domainSaveFlags(@Nonnull RemoteDomain dom, @Nonnull String to, String dxml, int flags);

    @XDRMethod(proc = 233)
    void domainRestoreFlags(@Nonnull String from, String dxml, int flags);

    @XDRMethod(proc = 234)
    void domainDestroyFlags(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 235)
    @Nonnull
    String domainSaveImageGetXmlDesc(@Nonnull String file, int flags);

    @XDRMethod(proc = 236)
    void domainSaveImageDefineXml(@Nonnull String file, @Nonnull String dxml, int flags);

    @XDRMethod(proc = 237)
    void domainBlockJobAbort(@Nonnull RemoteDomain dom, @Nonnull String path, int flags);

    @XDRMethod(proc = 238)
    RemoteDomainBlockJobInfo domainGetBlockJobInfo(@Nonnull RemoteDomain dom, @Nonnull String path, int flags);

    @XDRMethod(proc = 239)
    void domainBlockJobSetSpeed(@Nonnull RemoteDomain dom, @Nonnull String path, long bandwidth, int flags);

    @XDRMethod(proc = 240)
    void domainBlockPull(@Nonnull RemoteDomain dom, @Nonnull String path, long bandwidth, int flags);

    @XDRMethod(proc = 241)
    void domainEventBlockJob();

    @XDRMethod(proc = 242)
    long domainMigrateGetMaxSpeed(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 243)
    RemoteDomainBlockStatsFlags domainBlockStatsFlags(@Nonnull RemoteDomain dom, @Nonnull String path, int nparams, int flags);

    @XDRMethod(proc = 244)
    @Nonnull
    RemoteDomainSnapshot domainSnapshotGetParent(@Nonnull RemoteDomainSnapshot snap, int flags);

    @XDRMethod(proc = 245)
    void domainReset(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 246)
    int domainSnapshotNumChildren(@Nonnull RemoteDomainSnapshot snap, int flags);

    @XDRMethod(proc = 247)
    @Nonnull
    String[] domainSnapshotListChildrenNames(@Nonnull RemoteDomainSnapshot snap, int maxnames, int flags);

    @XDRMethod(proc = 248)
    void domainEventDiskChange();

    @XDRMethod(proc = 249)
    void domainOpenGraphics(@Nonnull RemoteDomain dom, int idx, int flags);

    @XDRMethod(proc = 250)
    void nodeSuspendForDuration(int target, long duration, int flags);

    @XDRMethod(proc = 251)
    void domainBlockResize(@Nonnull RemoteDomain dom, @Nonnull String disk, long size, int flags);

    @XDRMethod(proc = 252)
    void domainSetBlockIoTune(@Nonnull RemoteDomain dom, @Nonnull String disk, RemoteTypedParam[] params, int flags);

    @XDRMethod(proc = 253)
    RemoteDomainBlockIoTune domainGetBlockIoTune(@Nonnull RemoteDomain dom, String disk, int nparams, int flags);

    @XDRMethod(proc = 254)
    void domainSetNumaParameters(@Nonnull RemoteDomain dom, RemoteTypedParam[] params, int flags);

    @XDRMethod(proc = 255)
    RemoteDomainNumaParameters domainGetNumaParameters(@Nonnull RemoteDomain dom, int nparams, int flags);

    @XDRMethod(proc = 256)
    void domainSetInterfaceParameters(@Nonnull RemoteDomain dom, @Nonnull String device, RemoteTypedParam[] params, int flags);

    @XDRMethod(proc = 257)
    RemoteDomainInterfaceParameters domainGetInterfaceParameters(@Nonnull RemoteDomain dom, @Nonnull String device, int nparams, int flags);

    @XDRMethod(proc = 258)
    void domainShutdownFlags(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 259)
    void storageVolWipePattern(@Nonnull RemoteStorageVol vol, int algorithm, int flags);

    @XDRMethod(proc = 260)
    void storageVolResize(@Nonnull RemoteStorageVol vol, long capacity, int flags);

    @XDRMethod(proc = 261)
    void domainPmSuspendForDuration(@Nonnull RemoteDomain dom, int target, long duration, int flags);

    @XDRMethod(proc = 262)
    RemoteDomainCpuStats domainGetCpuStats(@Nonnull RemoteDomain dom, int nparams, int start_cpu, int ncpus, int flags);

    @XDRMethod(proc = 263)
    RemoteDomainDiskErrors domainGetDiskErrors(@Nonnull RemoteDomain dom, int maxerrors, int flags);

    @XDRMethod(proc = 264)
    void domainSetMetadata(@Nonnull RemoteDomain dom, int type, String metadata, String key, String uri, int flags);

    @XDRMethod(proc = 265)
    @Nonnull
    String domainGetMetadata(@Nonnull RemoteDomain dom, int type, String uri, int flags);

    @XDRMethod(proc = 266)
    void domainBlockRebase(@Nonnull RemoteDomain dom, @Nonnull String path, String base, long bandwidth, int flags);

    @XDRMethod(proc = 267)
    void domainPmWakeup(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 268)
    void domainEventTrayChange();

    @XDRMethod(proc = 269)
    void domainEventPmwakeup();

    @XDRMethod(proc = 270)
    void domainEventPmsuspend();

    @XDRMethod(proc = 271)
    int domainSnapshotIsCurrent(@Nonnull RemoteDomainSnapshot snap, int flags);

    @XDRMethod(proc = 272)
    int domainSnapshotHasMetadata(@Nonnull RemoteDomainSnapshot snap, int flags);

    @XDRMethod(proc = 273)
    RemoteConnectAllDomains connectListAllDomains(int need_results, int flags);

    @XDRMethod(proc = 274)
    RemoteDomainAllSnapshots domainListAllSnapshots(@Nonnull RemoteDomain dom, int need_results, int flags);

    @XDRMethod(proc = 275)
    RemoteDomainSnapshotAllChildren domainSnapshotListAllChildren(@Nonnull RemoteDomainSnapshot snapshot, int need_results, int flags);

    @XDRMethod(proc = 276)
    void domainEventBalloonChange();

    @XDRMethod(proc = 277)
    @Nonnull
    String domainGetHostname(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 278)
    RemoteDomainSecurityLabelList domainGetSecurityLabelList(@Nonnull RemoteDomain dom);

    @XDRMethod(proc = 279)
    void domainPinEmulator(@Nonnull RemoteDomain dom, int[] cpumap, int flags);

    @XDRMethod(proc = 280)
    RemoteDomainEmulatorPinInfo domainGetEmulatorPinInfo(@Nonnull RemoteDomain dom, int maplen, int flags);

    @XDRMethod(proc = 281)
    RemoteConnectAllStoragePools connectListAllStoragePools(int need_results, int flags);

    @XDRMethod(proc = 282)
    RemoteStoragePoolAllVolumes storagePoolListAllVolumes(@Nonnull RemoteStoragePool pool, int need_results, int flags);

    @XDRMethod(proc = 283)
    RemoteConnectAllNetworks connectListAllNetworks(int need_results, int flags);

    @XDRMethod(proc = 284)
    RemoteConnectAllInterfaces connectListAllInterfaces(int need_results, int flags);

    @XDRMethod(proc = 285)
    RemoteConnectAllNodeDevices connectListAllNodeDevices(int need_results, int flags);

    @XDRMethod(proc = 286)
    RemoteConnectAllNwfilters connectListAllNwfilters(int need_results, int flags);

    @XDRMethod(proc = 287)
    RemoteConnectAllSecrets connectListAllSecrets(int need_results, int flags);

    @XDRMethod(proc = 288)
    void nodeSetMemoryParameters(RemoteTypedParam[] params, int flags);

    @XDRMethod(proc = 289)
    RemoteNodeMemoryParameters nodeGetMemoryParameters(int nparams, int flags);

    @XDRMethod(proc = 290)
    void domainBlockCommit(@Nonnull RemoteDomain dom, @Nonnull String disk, String base, String top, long bandwidth, int flags);

    @XDRMethod(proc = 291)
    void networkUpdate(@Nonnull RemoteNetwork net, int command, int section, int parentIndex, @Nonnull String xml, int flags);

    @XDRMethod(proc = 292)
    void domainEventPmsuspendDisk();

    @XDRMethod(proc = 293)
    RemoteNodeCpuMap nodeGetCpuMap(int need_map, int need_online, int flags);

    @XDRMethod(proc = 294)
    void domainFstrim(@Nonnull RemoteDomain dom, String mountPoint, long minimum, int flags);

    @XDRMethod(proc = 295)
    void domainSendProcessSignal(@Nonnull RemoteDomain dom, long pid_value, int signum, int flags);

    @XDRMethod(proc = 296)
    void domainOpenChannel(@Nonnull RemoteDomain dom, String name, int flags);

    @XDRMethod(proc = 297)
    @Nonnull
    String /*RemoteNodeDevice*/  nodeDeviceLookupScsiHostByWwn(@Nonnull String wwnn, @Nonnull String wwpn, int flags);

    @XDRMethod(proc = 298)
    RemoteDomainJobStats domainGetJobStats(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 299)
    long domainMigrateGetCompressionCache(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 300)
    void domainMigrateSetCompressionCache(@Nonnull RemoteDomain dom, long cacheSize, int flags);

    @XDRMethod(proc = 301)
    void nodeDeviceDetachFlags(@Nonnull String name, String driverName, int flags);

    @XDRMethod(proc = 302)
    RemoteDomainMigrateBegin3Params domainMigrateBegin3Params(@Nonnull RemoteDomain dom, RemoteTypedParam[] params, int flags);

    @XDRMethod(proc = 303)
    RemoteDomainMigratePrepare3Params domainMigratePrepare3Params(RemoteTypedParam[] params, int[] cookie_in, int flags);

    @XDRMethod(proc = 304)
    int[] domainMigratePrepareTunnel3Params(RemoteTypedParam[] params, int[] cookie_in, int flags);

    @XDRMethod(proc = 305)
    int[] domainMigratePerform3Params(@Nonnull RemoteDomain dom, String dconnuri, RemoteTypedParam[] params, int[] cookie_in, int flags);

    @XDRMethod(proc = 306)
    RemoteDomainMigrateFinish3Params domainMigrateFinish3Params(RemoteTypedParam[] params, int[] cookie_in, int flags, int cancelled);

    @XDRMethod(proc = 307)
    void domainMigrateConfirm3Params(@Nonnull RemoteDomain dom, RemoteTypedParam[] params, int[] cookie_in, int flags, int cancelled);

    @XDRMethod(proc = 308)
    void domainSetMemoryStatsPeriod(@Nonnull RemoteDomain dom, int period, int flags);

    @XDRMethod(proc = 309)
    @Nonnull
    RemoteDomain domainCreateXmlWithFiles(@Nonnull String xml_desc, int flags);

    @XDRMethod(proc = 310)
    @Nonnull
    RemoteDomain domainCreateWithFiles(@Nonnull RemoteDomain dom, int flags);

    @XDRMethod(proc = 311)
    void domainEventDeviceRemoved();

    @XDRMethod(proc = 312)
    RemoteConnectCpuModelNames connectGetCpuModelNames(@Nonnull String arch, int need_results, int flags);

    @XDRMethod(proc = 313)
    int connectNetworkEventRegisterAny(int eventID, RemoteNetwork net);

    @XDRMethod(proc = 314)
    void connectNetworkEventDeregisterAny(int callbackID);

    @XDRMethod(proc = 315)
    void networkEventLifecycle();


}
